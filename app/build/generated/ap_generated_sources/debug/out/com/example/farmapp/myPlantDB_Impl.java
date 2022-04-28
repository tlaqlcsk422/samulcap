package com.example.farmapp;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class myPlantDB_Impl extends myPlantDB {
  private volatile myPlantDao _myPlantDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `myPlant` (`plantId` INTEGER NOT NULL, `myPlant_name` TEXT, `myPlant_humidity` TEXT, `myPlant_firstDay` TEXT, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `type` TEXT, `waterPeriod` TEXT, `temper` TEXT, `basicInfo` TEXT, `imageFile` INTEGER NOT NULL, `basicInfo_site` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '8bded9bb51fff8a35c1302ba100fdd14')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `myPlant`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsMyPlant = new HashMap<String, TableInfo.Column>(11);
        _columnsMyPlant.put("plantId", new TableInfo.Column("plantId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyPlant.put("myPlant_name", new TableInfo.Column("myPlant_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyPlant.put("myPlant_humidity", new TableInfo.Column("myPlant_humidity", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyPlant.put("myPlant_firstDay", new TableInfo.Column("myPlant_firstDay", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyPlant.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyPlant.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyPlant.put("waterPeriod", new TableInfo.Column("waterPeriod", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyPlant.put("temper", new TableInfo.Column("temper", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyPlant.put("basicInfo", new TableInfo.Column("basicInfo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyPlant.put("imageFile", new TableInfo.Column("imageFile", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyPlant.put("basicInfo_site", new TableInfo.Column("basicInfo_site", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMyPlant = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMyPlant = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMyPlant = new TableInfo("myPlant", _columnsMyPlant, _foreignKeysMyPlant, _indicesMyPlant);
        final TableInfo _existingMyPlant = TableInfo.read(_db, "myPlant");
        if (! _infoMyPlant.equals(_existingMyPlant)) {
          return new RoomOpenHelper.ValidationResult(false, "myPlant(com.example.farmapp.myPlant).\n"
                  + " Expected:\n" + _infoMyPlant + "\n"
                  + " Found:\n" + _existingMyPlant);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "8bded9bb51fff8a35c1302ba100fdd14", "660d20a1325f6da02b72ab7652e1eff1");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "myPlant");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `myPlant`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(myPlantDao.class, myPlantDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public myPlantDao myPlantDao() {
    if (_myPlantDao != null) {
      return _myPlantDao;
    } else {
      synchronized(this) {
        if(_myPlantDao == null) {
          _myPlantDao = new myPlantDao_Impl(this);
        }
        return _myPlantDao;
      }
    }
  }
}
