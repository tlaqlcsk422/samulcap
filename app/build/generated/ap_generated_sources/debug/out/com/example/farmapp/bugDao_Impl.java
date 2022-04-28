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
public final class bugDao_Impl implements bugDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<bug> __insertionAdapterOfbug;

  private final EntityDeletionOrUpdateAdapter<bug> __deletionAdapterOfbug;

  private final EntityDeletionOrUpdateAdapter<bug> __updateAdapterOfbug;

  public bugDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfbug = new EntityInsertionAdapter<bug>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `bug` (`id`,`type`,`basicInfo`,`solution`,`imageFile`,`basicInfo_site`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, bug value) {
        stmt.bindLong(1, value.getId());
        if (value.getType() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getType());
        }
        if (value.getBasicInfo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBasicInfo());
        }
        if (value.getSolution() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSolution());
        }
        stmt.bindLong(5, value.getImageFile());
        if (value.getBasicInfo_site() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getBasicInfo_site());
        }
      }
    };
    this.__deletionAdapterOfbug = new EntityDeletionOrUpdateAdapter<bug>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `bug` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, bug value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfbug = new EntityDeletionOrUpdateAdapter<bug>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `bug` SET `id` = ?,`type` = ?,`basicInfo` = ?,`solution` = ?,`imageFile` = ?,`basicInfo_site` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, bug value) {
        stmt.bindLong(1, value.getId());
        if (value.getType() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getType());
        }
        if (value.getBasicInfo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBasicInfo());
        }
        if (value.getSolution() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSolution());
        }
        stmt.bindLong(5, value.getImageFile());
        if (value.getBasicInfo_site() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getBasicInfo_site());
        }
        stmt.bindLong(7, value.getId());
      }
    };
  }

  @Override
  public void setInsertBug(final bug bug) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfbug.insert(bug);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void setDeleteBug(final bug bug) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfbug.handle(bug);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void setUpdateBug(final bug bug) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfbug.handle(bug);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<bug> getBugDBAll() {
    final String _sql = "SELECT * FROM bug";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfBasicInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "basicInfo");
      final int _cursorIndexOfSolution = CursorUtil.getColumnIndexOrThrow(_cursor, "solution");
      final int _cursorIndexOfImageFile = CursorUtil.getColumnIndexOrThrow(_cursor, "imageFile");
      final int _cursorIndexOfBasicInfoSite = CursorUtil.getColumnIndexOrThrow(_cursor, "basicInfo_site");
      final List<bug> _result = new ArrayList<bug>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final bug _item;
        _item = new bug();
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
        final String _tmpBasicInfo;
        if (_cursor.isNull(_cursorIndexOfBasicInfo)) {
          _tmpBasicInfo = null;
        } else {
          _tmpBasicInfo = _cursor.getString(_cursorIndexOfBasicInfo);
        }
        _item.setBasicInfo(_tmpBasicInfo);
        final String _tmpSolution;
        if (_cursor.isNull(_cursorIndexOfSolution)) {
          _tmpSolution = null;
        } else {
          _tmpSolution = _cursor.getString(_cursorIndexOfSolution);
        }
        _item.setSolution(_tmpSolution);
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
