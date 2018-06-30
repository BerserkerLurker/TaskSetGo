/*
 * Created by Ahmed Karim on 30/06/18 20:46
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 30/06/18 20:46
 */

package com.onadasoft.tasksetgo.db.converter;

import android.arch.persistence.room.TypeConverter;

import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.format.DateTimeFormatter;

public class DateConverter {

    private static DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    @TypeConverter
    public static OffsetDateTime toOffsetDateTime(String value){
        return value == null ? null : formatter.parse(value, OffsetDateTime.FROM);
    }

    @TypeConverter
    public String fromOffsetDateTime(OffsetDateTime date){
        return date == null ? null : date.format(formatter);
    }

}