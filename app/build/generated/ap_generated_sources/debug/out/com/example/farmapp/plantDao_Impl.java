package com.example.farmapp;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class plantDao_Impl implements plantDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<plant> __insertionAdapterOfplant;

  private final EntityDeletionOrUpdateAdapter<plant> __deletionAdapterOfplant;

  private final EntityDeletionOrUpdateAdapter<plant> __updateAdapterOfplant;

  public plantDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfplant = new EntityInsertionAdapter<plant>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `plant` (`id`,`type`,`waterPeriod`,`temper`,`basicInfo`,`imageFile`,`basicInfo_site`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, plant value) {
        stmt.bindLong(1, value.getId());
        if (value.getType() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getType());
        }
        if (value.getWaterPeriod() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getWaterPeriod());
        }
        if (value.getTemper() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTemper());
        }
        if (value.getBasicInfo() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getBasicInfo());
        }
        stmt.bindLong(6, value.getImageFile());
        if (value.getBasicInfo_site() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getBasicInfo_site());
        }
      }
    };
    this.__deletionAdapterOfplant = new EntityDeletionOrUpdateAdapter<plant>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `plant` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, plant value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfplant = new EntityDeletionOrUpdateAdapter<plant>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `plant` SET `id` = ?,`type` = ?,`waterPeriod` = ?,`temper` = ?,`basicInfo` = ?,`imageFile` = ?,`basicInfo_site` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, plant value) {
        stmt.bindLong(1, value.getId());
        if (value.getType() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getType());
        }
        if (value.getWaterPeriod() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getWaterPeriod());
        }
        if (value.getTemper() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTemper());
        }
        if (value.getBasicInfo() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getBasicInfo());
        }
        stmt.bindLong(6, value.getImageFile());
        if (value.getBasicInfo_site() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getBasicInfo_site());
        }
        stmt.bindLong(8, value.getId());
      }
    };
  }

  @Override
  public void setInsertPlant(final plant plant) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfplant.insert(plant);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void setDeletePlant(final plant plant) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfplant.handle(plant);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void setUpdatePlant(final plant plant) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfplant.handle(plant);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<plant> getPlantDBAll() {
    final String _sql = "SELECT * FROM plant";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfWaterPeriod = CursorUtil.getColumnIndexOrThrow(_cursor, "waterPeriod");
      final int _cursorIndexOfTemper = CursorUtil.getColumnIndexOrThrow(_cursor, "temper");
      final int _cursorIndexOfBasicInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "basicInfo");
      final int _cursorIndexOfImageFile = CursorUtil.getColumnIndexOrThrow(_cursor, "imageFile");
      final int _cursorIndexOfBasicInfoSite = CursorUtil.getColumnIndexOrThrow(_cursor, "basicInfo_site");
      final List<plant> _result = new ArrayList<plant>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final plant _item;
        _item = new plant();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpType;
        if (_cursor.isNull(_cursorIndexOfType)) {
          _tmpType = null;
        } else {
          _tmpType = _cursor.getString(_cursorIndexOfType);
        }
        _item.setType(_tmpType);
        final String _tmpWaterPeriod;
        if (_cursor.isNull(_cursorIndexOfWaterPeriod)) {
          _tmpWaterPeriod = null;
        } else {
          _tmpWaterPeriod = _cursor.getString(_cursorIndexOfWaterPeriod);
        }
        _item.setWaterPeriod(_tmpWaterPeriod);
        final String _tmpTemper;
        if (_cursor.isNull(_cursorIndexOfTemper)) {
          _tmpTemper = null;
        } else {
          _tmpTemper = _cursor.getString(_cursorIndexOfTemper);
        }
        _item.setTemper(_tmpTemper);
        final String _tmpBasicInfo;
        if (_cursor.isNull(_cursorIndexOfBasicInfo)) {
          _tmpBasicInfo = null;
        } else {
          _tmpBasicInfo = _cursor.getString(_cursorIndexOfBasicInfo);
        }
        _item.setBasicInfo(_tmpBasicInfo);
        final int _tmpImageFile;
        _tmpImageFile = _cursor.getInt(_cursorIndexOfImageFile);
        _item.setImageFile(_tmpImageFile);
        final String _tmpBasicInfo_site;
        if (_cursor.isNull(_cursorIndexOfBasicInfoSite)) {
          _tmpBasicInfo_site = null;
        } else {
          _tmpBasicInfo_site = _cursor.getString(_cursorIndexOfBasicInfoSite);
        }
        _item.setBasicInfo_site(_tmpBasicInfo_site);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
