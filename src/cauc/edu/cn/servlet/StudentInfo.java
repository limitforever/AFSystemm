package cauc.edu.cn.servlet;

import java.util.List;

public class StudentInfo {
private String name;
private String age;
private List<Integer> grade;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public List<Integer> getGrade() {
	return grade;
}
public void setGrade(List<Integer> allgrade) {
	this.grade = allgrade;
}

}