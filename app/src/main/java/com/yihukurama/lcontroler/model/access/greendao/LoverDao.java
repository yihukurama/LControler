package com.yihukurama.lcontroler.model.access.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.yihukurama.lcontroler.model.access.greendao.Lover;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table LOVER.
*/
public class LoverDao extends AbstractDao<Lover, String> {

    public static final String TABLENAME = "LOVER";

    /**
     * Properties of entity Lover.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Userid = new Property(0, String.class, "userid", true, "USERID");
        public final static Property Account = new Property(1, String.class, "account", false, "ACCOUNT");
        public final static Property Nickname = new Property(2, String.class, "nickname", false, "NICKNAME");
        public final static Property Headurl = new Property(3, String.class, "headurl", false, "HEADURL");
        public final static Property Birthyear = new Property(4, String.class, "birthyear", false, "BIRTHYEAR");
        public final static Property Birthmonth = new Property(5, String.class, "birthmonth", false, "BIRTHMONTH");
        public final static Property Birthday = new Property(6, String.class, "birthday", false, "BIRTHDAY");
        public final static Property Birthhour = new Property(7, String.class, "birthhour", false, "BIRTHHOUR");
        public final static Property Birthmin = new Property(8, String.class, "birthmin", false, "BIRTHMIN");
        public final static Property Birthsec = new Property(9, String.class, "birthsec", false, "BIRTHSEC");
        public final static Property Heigh = new Property(10, String.class, "heigh", false, "HEIGH");
        public final static Property Weight = new Property(11, String.class, "weight", false, "WEIGHT");
        public final static Property Chest = new Property(12, String.class, "chest", false, "CHEST");
        public final static Property Waistline = new Property(13, String.class, "waistline", false, "WAISTLINE");
        public final static Property Hipline = new Property(14, String.class, "hipline", false, "HIPLINE");
        public final static Property Clothessize = new Property(15, String.class, "clothessize", false, "CLOTHESSIZE");
        public final static Property Shoessize = new Property(16, String.class, "shoessize", false, "SHOESSIZE");
        public final static Property Trouserssize = new Property(17, String.class, "trouserssize", false, "TROUSERSSIZE");
        public final static Property Interests = new Property(18, String.class, "interests", false, "INTERESTS");
        public final static Property Hate = new Property(19, String.class, "hate", false, "HATE");
    };


    public LoverDao(DaoConfig config) {
        super(config);
    }
    
    public LoverDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'LOVER' (" + //
                "'USERID' TEXT PRIMARY KEY NOT NULL ," + // 0: userid
                "'ACCOUNT' TEXT," + // 1: account
                "'NICKNAME' TEXT," + // 2: nickname
                "'HEADURL' TEXT," + // 3: headurl
                "'BIRTHYEAR' TEXT," + // 4: birthyear
                "'BIRTHMONTH' TEXT," + // 5: birthmonth
                "'BIRTHDAY' TEXT," + // 6: birthday
                "'BIRTHHOUR' TEXT," + // 7: birthhour
                "'BIRTHMIN' TEXT," + // 8: birthmin
                "'BIRTHSEC' TEXT," + // 9: birthsec
                "'HEIGH' TEXT," + // 10: heigh
                "'WEIGHT' TEXT," + // 11: weight
                "'CHEST' TEXT," + // 12: chest
                "'WAISTLINE' TEXT," + // 13: waistline
                "'HIPLINE' TEXT," + // 14: hipline
                "'CLOTHESSIZE' TEXT," + // 15: clothessize
                "'SHOESSIZE' TEXT," + // 16: shoessize
                "'TROUSERSSIZE' TEXT," + // 17: trouserssize
                "'INTERESTS' TEXT," + // 18: interests
                "'HATE' TEXT);"); // 19: hate
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'LOVER'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Lover entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getUserid());
 
        String account = entity.getAccount();
        if (account != null) {
            stmt.bindString(2, account);
        }
 
        String nickname = entity.getNickname();
        if (nickname != null) {
            stmt.bindString(3, nickname);
        }
 
        String headurl = entity.getHeadurl();
        if (headurl != null) {
            stmt.bindString(4, headurl);
        }
 
        String birthyear = entity.getBirthyear();
        if (birthyear != null) {
            stmt.bindString(5, birthyear);
        }
 
        String birthmonth = entity.getBirthmonth();
        if (birthmonth != null) {
            stmt.bindString(6, birthmonth);
        }
 
        String birthday = entity.getBirthday();
        if (birthday != null) {
            stmt.bindString(7, birthday);
        }
 
        String birthhour = entity.getBirthhour();
        if (birthhour != null) {
            stmt.bindString(8, birthhour);
        }
 
        String birthmin = entity.getBirthmin();
        if (birthmin != null) {
            stmt.bindString(9, birthmin);
        }
 
        String birthsec = entity.getBirthsec();
        if (birthsec != null) {
            stmt.bindString(10, birthsec);
        }
 
        String heigh = entity.getHeigh();
        if (heigh != null) {
            stmt.bindString(11, heigh);
        }
 
        String weight = entity.getWeight();
        if (weight != null) {
            stmt.bindString(12, weight);
        }
 
        String chest = entity.getChest();
        if (chest != null) {
            stmt.bindString(13, chest);
        }
 
        String waistline = entity.getWaistline();
        if (waistline != null) {
            stmt.bindString(14, waistline);
        }
 
        String hipline = entity.getHipline();
        if (hipline != null) {
            stmt.bindString(15, hipline);
        }
 
        String clothessize = entity.getClothessize();
        if (clothessize != null) {
            stmt.bindString(16, clothessize);
        }
 
        String shoessize = entity.getShoessize();
        if (shoessize != null) {
            stmt.bindString(17, shoessize);
        }
 
        String trouserssize = entity.getTrouserssize();
        if (trouserssize != null) {
            stmt.bindString(18, trouserssize);
        }
 
        String interests = entity.getInterests();
        if (interests != null) {
            stmt.bindString(19, interests);
        }
 
        String hate = entity.getHate();
        if (hate != null) {
            stmt.bindString(20, hate);
        }
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Lover readEntity(Cursor cursor, int offset) {
        Lover entity = new Lover( //
            cursor.getString(offset + 0), // userid
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // account
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // nickname
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // headurl
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // birthyear
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // birthmonth
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // birthday
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // birthhour
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // birthmin
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // birthsec
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // heigh
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // weight
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // chest
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // waistline
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // hipline
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // clothessize
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // shoessize
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // trouserssize
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // interests
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19) // hate
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Lover entity, int offset) {
        entity.setUserid(cursor.getString(offset + 0));
        entity.setAccount(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setNickname(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setHeadurl(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setBirthyear(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setBirthmonth(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setBirthday(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setBirthhour(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setBirthmin(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setBirthsec(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setHeigh(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setWeight(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setChest(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setWaistline(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setHipline(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setClothessize(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setShoessize(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setTrouserssize(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setInterests(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setHate(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(Lover entity, long rowId) {
        return entity.getUserid();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(Lover entity) {
        if(entity != null) {
            return entity.getUserid();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
