var app = angular.module("app", []);
app.controller("ctrl", function ($scope, $http) {
    $scope.import = function(files) {
        var reader = new FileReader();

        reader.onloadend = async () => {
            try {
                var workbook = new ExcelJS.Workbook();
                await workbook.xlsx.load(reader.result);

                const worksheet = workbook.getWorksheet('Sheet1'); // Đảm bảo đúng tên sheet
                worksheet.eachRow((row, index) => {
                    if (index > 1) { // Bỏ qua dòng tiêu đề
                        let student = {
                            email: row.getCell(1).value.text,
                            fullname: row.getCell(2).value,
                            marks: +row.getCell(3).value,
                            gender: true && row.getCell(4).value, // True nếu là Male
                            country: row.getCell(5).value
                        };

                        var url = "http://localhost:8080/rest/students";
                        $http.post(url, student)
                            .then(resp => {
                                console.log("Success:", resp);
                                document.getElementById("output").innerHTML += `<p>Success: ${student.email}</p>`;
                            })
                            .catch(error => {
                                console.error("Error:", error);
                                document.getElementById("output").innerHTML += `<p>Error: ${error.statusText}</p>`;
                            });
                    }
                });
                $scope.$apply(); // Cập nhật lại scope nếu cần
            } catch (err) {
                console.error("Error processing file:", err);
            }
        };

        reader.readAsArrayBuffer(files[0]); // Đọc file Excel
    };
});
