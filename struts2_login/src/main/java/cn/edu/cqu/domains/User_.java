package cn.edu.cqu.domains;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-11-10T03:27:10.473+0800")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, Long> id;
	public static volatile SingularAttribute<User, String> loginName;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SingularAttribute<User, String> pwd;
	public static volatile SingularAttribute<User, String> type;
	public static volatile SingularAttribute<User, String> sex;
	public static volatile SingularAttribute<User, String> mobilePhone;
	public static volatile SingularAttribute<User, String> email;
}
