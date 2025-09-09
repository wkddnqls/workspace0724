package com.kh.example.gearrent;

import java.util.Objects;

public class Member {
private String id ;
private String name ;
public Member() {
	super();
}
public Member(String id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public int hashCode() {
	// TODO Auto-generated method stub
	return Objects.hash(id);
}
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Member)) return false;
    Member member = (Member) o;
    return Objects.equals(id, member.id);
}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return 
            "" + id + '\'' +
            "" + name + '\'' ;
}


}
