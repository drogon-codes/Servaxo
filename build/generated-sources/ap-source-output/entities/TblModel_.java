package entities;

import entities.TblCompany;
import entities.TblParts;
import entities.TblServiceorder;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-02-27T16:12:59")
@StaticMetamodel(TblModel.class)
public class TblModel_ { 

    public static volatile CollectionAttribute<TblModel, TblServiceorder> tblServiceorderCollection;
    public static volatile SingularAttribute<TblModel, String> modelName;
    public static volatile SingularAttribute<TblModel, String> createdAt;
    public static volatile CollectionAttribute<TblModel, TblParts> tblPartsCollection;
    public static volatile SingularAttribute<TblModel, TblCompany> companyId;
    public static volatile SingularAttribute<TblModel, String> modelImg;
    public static volatile SingularAttribute<TblModel, Integer> modelId;
    public static volatile SingularAttribute<TblModel, String> updatedAt;

}