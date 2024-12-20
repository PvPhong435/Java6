package com.J601.app;

import java.nio.channels.Pipe.SourceChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.J601.bean.Student;

public class Lambda {
	public static void main(String[] args) {
		 demo1();
		 demo2();
		 demo3();
		demo4();
	}

	private static void demo4() {
		// Phương pháp truyền thống
		Demo4inter o = new Demo4inter() {

			@Override
			public void m1(int x) {
				System.out.println(x);

			}
		};

		// Phương pháp lambda
		Demo4inter o2 = (x) -> {
			System.out.println(x);
		};

		// Nếu là 1 đối số chúng ta có thể bỏ ngoặc tròn còn nếu 1 dòng lệnh chúng ta có
		// thể bỏ ngoặc nhọn
		Demo4inter o3 = x -> System.out.println(x);

		o.m1(2024);
		o2.m1(2025);
		o3.m1(2023);
	}

	private static void demo3() {
		List<Student> list = Arrays.asList(new Student("Nguyễn Văn Tèo", true, 7.5),
				new Student("Trần Thị Thu Hương", false, 5.5), new Student("Phạm Đức Cường", true, 9.5),
				new Student("Lê thị Mỹ Hồng", false, 6.5), new Student("Đoàn Thị Kim Ty", false, 8.0));
		// đây là sắp xếp sử dụng phương pháp lambda
		Collections.sort(list, (sv1, sv2) -> sv1.getMarks().compareTo(sv2.getMarks()));

		// Đây là sử dụng phương pháp thường
		System.out.println("Kết quả của sử dụng cách thông thường");
		for (Student sv : list) {
			System.out.println("Name: " + sv.getName());
			System.out.println("Marks: " + sv.getMarks());
			System.out.println("-----------------------------");
		}

		// đây là sắp xếp sử dụng phương pháp lambda
		Collections.sort(list, (sv1, sv2) -> sv2.getMarks().compareTo(sv1.getMarks()));
		// đây là sử dụng phương pháp lambda
		System.out.println("\nKết quả của sử dụng biểu thức lambda");
		list.forEach(sv -> {
			System.out.println("Name: " + sv.getName());
			System.out.println("Marks: " + sv.getMarks());
			System.out.println("-----------------------------");
		});
	}

	private static void demo2() {
		List<Student> list = Arrays.asList(new Student("Nguyễn Văn Tèo", true, 7.5),
				new Student("Trần Thị Thu Hương", false, 5.5), new Student("Phạm Đức Cường", true, 9.5),
				new Student("Lê thị Mỹ Hồng", false, 6.5), new Student("Đoàn Thị Kim Ty", false, 8.0));
		// Đây là sử dụng phương pháp thường
		System.out.println("Kết quả của sử dụng cách thông thường");
		for (Student sv : list) {
			System.out.println("Name: " + sv.getName());
			System.out.println("Marks: " + sv.getMarks());
			System.out.println("-----------------------------");
		}

		// đây là sử dụng phương pháp lambda
		System.out.println("\nKết quả của sử dụng biểu thức lambda");
		list.forEach(sv -> {
			System.out.println("Name: " + sv.getName());
			System.out.println("Marks: " + sv.getMarks());
			System.out.println("-----------------------------");
		});

	}

	private static void demo1() {
		List<Integer> list = Arrays.asList(1, 9, 4, 7, 5, 2);

		// Đây là biểu thức thường
		System.out.println("Kết quả của sử dụng cách thông thường");
		for (Integer num : list) {
			System.out.print(num);
		}

		System.out.println("\nKết quả của sử dụng biểu thức lambda");
		// đây là biểu thức lambda
		list.forEach(num -> System.out.print(num));

	}

}

@FunctionalInterface
interface Demo4inter {
	void m1(int x);

	default void m2() {
	};

	public static void m3() {
	}
}
