package com.nt.bo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("stBO")
@Scope("prototype")
public class StudentBO extends BaseBean {
	private  String sadd;
	private  String course;
	private  int total;
	private  float avg;
	
	public StudentBO() {
		System.out.println("StudentBO:: 0-param constructor");
	}
	
	public String getSadd() {
		return sadd;
	}
	public void setSadd(String sadd) {
		this.sadd = sadd;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public float getAvg() {
		return avg;
	}
	public void setAvg(float avg) {
		this.avg = avg;
	}
	@Override
	public String toString() {
		return "StudentBO [sadd=" + sadd + ", course=" + course + ", total=" + total + ", avg=" + avg + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
}
