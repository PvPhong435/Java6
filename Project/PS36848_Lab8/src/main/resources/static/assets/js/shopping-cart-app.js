const app = angular.module("shopping-cart-app", []);

app.filter('customNumber', function() {
    return function(input) {
        if (input) {
            var formatted = input.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".");
            return formatted.replace(/,/g, ".");
        }
        return input;
    };
});

app.controller("shopping-cart-ctrl", function ($scope, $http) {
    $scope.cart = {
        items: [],
        add(id) {
           const item = this.items.find(item => item.id === id);
           if (item) {
               item.qty++;
               this.saveToLocalStorage();
           } else {
               $http.get(`/rest/products/${id}`).then(resp => {
                   console.log(resp.data);
                   resp.data.qty = 1;
                   this.items.push(resp.data);
                   this.saveToLocalStorage();
               }).catch(err => console.log(err));
           }
        },
        remove(id) {
            const index = this.items.findIndex(item => item.id === id);
            this.items.splice(index, 1);
            this.saveToLocalStorage();
        },
        clear() {
            this.items = [];
            this.saveToLocalStorage();
        },
        amt_of(item) {},
        get count() {
           return this.items
               .map(item => item.qty)
               .reduce((total, qty) => total + qty, 0);
        },
        get amount() {
           return this.items
               .map(item => item.qty * item.price)
               .reduce((total, qty) => total + qty, 0);
        },
        saveToLocalStorage() {
           const json = JSON.stringify(angular.copy(this.items));
           localStorage.setItem("cart", json);
        },
        loadFromLocalStorage() {
            const json = localStorage.getItem("cart");
            this.items = json ? JSON.parse(json) : [];
        }
    }

    $scope.cart.loadFromLocalStorage();

    $scope.order = {
        createDate: new Date(),
        address: "",
        account: {
            username: $("#purchaser").text()
        },
        get orderDetails() {
            return $scope.cart.items.map(item => {
                return {
                    product: {id: item.id},
                    price: item.price,
                    quantity: item.qty
                }
            })
        },
        purchase() {
            const order = angular.copy(this);
            $http.post(`/rest/orders`, order).then(resp => {
                alert("Đặt hàng thành công!");
                $scope.cart.clear();
                location.href = "/order/detail/" + resp.data.id;
            }).catch(err => {
                alert("Đặt hàng lỗi!");
                console.log(err);
            })
        }
    }
});