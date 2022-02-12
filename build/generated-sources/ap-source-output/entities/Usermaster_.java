package entities;

import entities.Groupmaster;
import entities.TblServicecart;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-02-12T13:35:06")
@StaticMetamodel(Usermaster.class)
public class Usermaster_ { 

    public static volatile SingularAttribute<Usermaster, String> regDatetime;
    public static volatile SingularAttribute<Usermaster, String> password;
    public static volatile SingularAttribute<Usermaster, String> contact;
    public static volatile SingularAttribute<Usermaster, Groupmaster> groupId;
    public static volatile SingularAttribute<Usermaster, String> name;
    public static volatile CollectionAttribute<Usermaster, TblServicecart> tblServicecartCollection;
    public static volatile SingularAttribute<Usermaster, Integer> userId;
    public static volatile SingularAttribute<Usermaster, String> username;
    public static volatile SingularAttribute<Usermaster, String> updatedAt;

}