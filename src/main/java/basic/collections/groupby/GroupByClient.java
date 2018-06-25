package basic.collections.groupby;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupByClient {
	public static void main(String [] args){
		List<Integer> scoreList = new ArrayList<>();
		scoreList.add(1);
		scoreList.add(1);
		scoreList.add(1);
		scoreList.add(2);
		scoreList.add(3);
		
		System.out.println(scoreList.stream().
				collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))); 
		
//		System.out.println(scoreList.stream().
//				collect(Collectors.groupingBy(Function.identity(), Collectors.)));
		
		List<Student> studentList = new ArrayList<>();
		
		GroupByClient gc = new GroupByClient();
		studentList.add(gc.newStudent("Boy1", 100, "국어"));
		studentList.add(gc.newStudent("Boy1", 100, "수학"));
		studentList.add(gc.newStudent("Boy1", 100, "영어"));
		studentList.add(gc.newStudent("Boy1", 100, "사회"));
		
		studentList.add(gc.newStudent("Boy2", 88, "국어"));
		studentList.add(gc.newStudent("Boy2", 89, "수학"));
		studentList.add(gc.newStudent("Boy2", 99, "영어"));
		studentList.add(gc.newStudent("Boy2", 92, "사회"));
		
		studentList.add(gc.newStudent("Boy3", 78, "국어"));
		studentList.add(gc.newStudent("Boy3", 79, "수학"));
		studentList.add(gc.newStudent("Boy3", 89, "영어"));
		studentList.add(gc.newStudent("Boy3", 82, "사회"));
		Stream<Student> streamList = studentList.stream();
		//streamList.collect(Collectors.groupingBy(p -> p.getName(), mapping((Student s)->s.name, toList())));
		Object obj = studentList.stream().collect(Collectors.groupingBy(Student::getDept));
		System.out.println(obj.getClass().getName());

		Map<String, List<Student>> result = studentList.stream().collect(Collectors.groupingBy(Student::getDept));
		System.out.println(result);
		for(String key :result.keySet()){
			System.out.println(key + " : " + result.get(key).get(1).getName());
		}
	}

	public Student newStudent(String name, int score, String dept){
		Student s = new Student(name, score, dept);
		return s;
	}
	
	class Student{
		public Integer score;
		public String name;
		public String dept;
		
		public Student(String name, int score, String dept){
			setName(name);
			setScore(score);
			setDept(dept);
		}
		
		public Integer getScore() {
			return score;
		}
		public void setScore(Integer score) {
			this.score = score;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		public String getDept() {
			return dept;
		}

		public void setDept(String dept) {
			this.dept = dept;
		}
		
		
	}
}
