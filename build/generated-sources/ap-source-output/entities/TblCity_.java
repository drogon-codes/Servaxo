package entities;

import entities.TblOrder;
import entities.TblState;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-02-27T16:12:59")
@StaticMetamodel(TblCity.class)
public class TblCity_ { 

    public static volatile SingularAttribute<TblCity, String> createdAt;
    public static volatile SingularAttribute<TblCity, String> cityName;
    public static volatile SingularAttribute<TblCity, String> cityCode;
    public static volatile CollectionAttribute<TblCity, TblOrder> tblOrderCollection;
    public static volatile SingularAttribute<TblCity, TblState> stateId;
    public static volatile SingularAttribute<TblCity, Integer> cityId;
    public static volatile SingularAttribute<TblCity, String> updatedAt;

}