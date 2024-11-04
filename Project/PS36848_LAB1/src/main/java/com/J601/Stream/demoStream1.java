package com.J601.Stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.J601.bean.Staff;

public class demoStream1 {
	public static void main(String[] args) {
//		Demo1();
//		Demo2();
		// Demo3();
		Demo4();
		//Demo5();
		//Demo6();
		//Demo7();
	}

	public static void Demo1() {
		Staff nv1 = new Staff("Tuấn", 100);
		Staff nv2 = new Staff("Hương", 200);
		Staff nv3 = new Staff("Hạnh", 150);
		List<Staff> list = Arrays.asList(nv1, nv2, nv3);

		// Cách tạo steam đầu tiên bằng cách add từng phần tử vào
		Stream<Staff> s1 = Stream.of(nv1, nv2, nv3);
		// Xuất kết quả
		s1.forEach(n -> System.out.println(n));

		// Cách tạo stream từ collection đã tạo trước đó
		Stream<Staff> s2 = list.stream();
		// Xuất kết quả
		s2.forEach(n -> System.out.println(n));
	}

	public static void Demo2() {
		List<Integer> list = Arrays.asList(2, 1, 3, 7, 8, 4, 5);
		double a = list.stream().filter(n -> n % 2 == 0)
				.peek(System.out::println)
				.map(n -> Math.sqrt(n))
				.mapToDouble(n -> n)
				.average().getAsDouble();
		System.out.println("Kết quả là: " + a);
	}

	public static void Demo3() {
		// Cách sử dụng foreach trong stream
		Staff nv1 = new Staff("Tuấn", 100);
		Staff nv2 = new Staff("Hương", 200);
		Staff nv3 = new Staff("Hạnh", 150);
		List<Staff> list = Arrays.asList(nv1, nv2, nv3);
		// Ví dụ cách sử dụng foreach trong stream
		list.stream().forEach(s -> s.setSalary(s.getSalary() * 2));
		// Xuất kết quả
		list.forEach(n -> System.out.println(n));

		// Ví dụ cách sử dụng foreach trong stream và in hoa tên lên
		list.stream().forEach(s -> {
			s.setSalary(s.getSalary() * 2);
			s.setName(s.getName().toUpperCase());
		});
		// Xuất kết quả
		list.forEach(n -> System.out.println(n));
	}

	public static void Demo4() {
		// Cách sử dụng Filter trong stream
		Staff nv1 = new Staff("Tuấn", 100); 
		Staff nv2 = new Staff("Hương", 200);
		Staff nv3 = new Staff("Hạnh", 150);
		List<Staff> list = Arrays.asList(nv1, nv2, nv3);

		// lỌC LẤY các nhân viên có lương dưới 200
		list.stream().filter(staff -> staff.getSalary() < 200).forEach(staff -> System.out.println(staff));

		// Lọc lấy các nhân viên có tên bắt đầu bằng chữ H
		list.stream().filter(staff -> staff.getName().startsWith("H")).forEach(staff -> System.out.println(staff));

		// Lọc lấy các nhân viên có tên bắt đầu bằng chữ H sau đó chyển sang collection để gán vào listChange
		List<Staff>listChange=list.stream().filter(staff -> staff.getName().startsWith("H")).collect(Collectors.toList());

		// Xuất list sau khi sử dụng collect
		System.out.println("cách 1");
		list.stream().forEach(staff->System.out.println(staff));
		System.out.println("cách 2");
		list.forEach(staff->System.out.println(staff));
		System.out.println("Xuất list sau khi đã filter lấy những ai có chữ cái đầu là H");
		listChange.forEach(s->System.out.println(s));
		
	}
	
	public static void Demo5()
	{
		//Sử dụng các hàm như allMatch, anyMatch, noneMatch
		Staff nv1 = new Staff("Tuấn", 100); 
		Staff nv2 = new Staff("Hương", 200);
		Staff nv3 = new Staff("Hạnh", 150);
		List<Staff> list = Arrays.asList(nv1, nv2, nv3);
		Staff nv4 = new Staff("Tuấn", 100);
		
		//kiểm tra nếu tất cả nhân viên đều có mức lương bé hơn 300 thì nó sẽ thỏa mãn if
		if(list.stream().allMatch(staff->staff.getSalary()<300))
		{
			System.out.println("tất cả nhân viên có lương bé hơn 300");
		}
		//kiểm tra nếu có bất kỳ nhân viên nào có mức lương bé hơn 200 thì nó sẽ thỏa mãn if
		if(list.stream().anyMatch(staff->staff.getSalary()<200))
		{
			System.out.println("Một số nhân viên có lương bé hơn 200");
		}
		//kiểm tra nếu không có bất kỳ nhân viên có mức lương bé hơn 300 thì nó sẽ thỏa mãn if
		if(list.stream().noneMatch(staff->staff.getSalary()<300))
		{
			System.out.println("Không có nhân viên nào có lương bé hơn 300");
		}
		//thử nghiệm kiểm tra xem trong danh sách có đối tượng nv1 chưa
		if(list.stream().anyMatch(staff->staff==nv1))
		{
			System.out.println("kiểm tra xem có bất kì nhân viên nào giống với đối tượng nv1 không");
		}
		//thử nghiệm kiểm tra xem trong danh sách có đối tượng nv4 chưa
		if(list.stream().anyMatch(staff->staff==nv4))
		{
			System.out.println("kiểm tra xem có bất kì nhân viên nào giống với đối tượng nv4 không");
		}
	}
	
	public static void Demo6()
	{
		//Cách sử dụng các hàm như Count,sum,min,max,average
		//ngoại trừ hàm Count thì các hàm còn lại ở trên đều phải được chuyển 1 collection hoặc map về <Number>Stream trước khi thực hiện
		
		Staff nv1 = new Staff("Tuấn", 100);
		Staff nv2 = new Staff("Hương", 200);
		Staff nv3 = new Staff("Hạnh", 150);
		List<Staff> list = Arrays.asList(nv1, nv2, nv3);
		
		List<Integer> listNum = Arrays.asList(2, 1, 3, 7, 8, 4, 5);
		
		//ví dụ đếm số lượng phần tử trong list các staff
		Long countStaff=list.stream().count();
		System.out.println("Số lượng phần tử trong danh sách staff: "+countStaff);
		
		//lấy giá trị lương sau đó chuyển sang double sau đó tính sum
		Double sumSalary=list.stream().mapToDouble(staff->staff.getSalary()).sum();
		System.out.println("Tổng lương toàn bộ staff trong list là: "+sumSalary);
		
		//lấy giá trị lương sau đó chuyển sang double sau đó lấy lương thấp nhất
		Double minSalary=list.stream().mapToDouble(staff->staff.getSalary()).min().orElse(0);
		System.out.println("Lương thấp nhất trong danh sách staff là: "+minSalary );
		
		//lấy giá trị lương sau đó chuyển sang double sau đó lấy lương thấp nhất
		Double maxSalary=list.stream().mapToDouble(staff->staff.getSalary()).max().orElse(0);
		System.out.println("Lương thấp nhất trong danh sách staff là: "+maxSalary );
	}

	public static void Demo7()
	{
		//cách sử dụng tham chiếu trong lambda
		//Cách xuất lambda bình thường
		Stream.of("Tèo","Phèo","Kèo").forEach(s->System.out.println(s));
		//Cách xuất theo kiểu tham chiếu
		Stream.of("Tèo","Phèo","Kèo").forEach(System.out::println);
		
		//Cách gọi 1 hàm toán học bình thường
		Stream.of(5,7,9).map(n->Math.sqrt(n)).forEach(n->System.out.println(n));
		
		//Cách gọi 1 hàm toán học theo kiểu tham chiếu
		Stream.of(5,7,9).map(Math::sqrt).forEach(System.out::println);
		
		//Cách in hoa toàn bộ chuỗi trong list bình thường theo dạng lambda
		Stream.of("Tèo","Phèo","Kèo").map(staff->staff.toUpperCase()).forEach(staff->System.out.println(staff));
		
		//Cách in hoa toàn bộ chuỗi trong list theo dạng tham chiếu
		Stream.of("Tèo","Phèo","Kèo").map(String::toUpperCase).forEach(System.out::println);
	}
}
