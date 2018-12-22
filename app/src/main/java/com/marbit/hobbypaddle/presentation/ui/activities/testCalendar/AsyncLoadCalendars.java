/*
 * Copyright (c) 2012 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.marbit.hobbypaddle.presentation.ui.activities.testCalendar;

import android.util.Log;

import com.google.api.services.calendar.model.CalendarList;
import com.marbit.hobbypaddle.presentation.ui.activities.CalendarTestActivity;

import java.io.IOException;

/**
 * Asynchronously load the calendars.
 * 
 * @author Yaniv Inbar
 */
public class AsyncLoadCalendars extends CalendarAsyncTask {

  AsyncLoadCalendars(CalendarTestActivity calendarSample) {
    super(calendarSample);
  }

  @Override
  protected void doInBackground() throws IOException {
    CalendarList feed = client.calendarList().list().setFields(CalendarInfo.FEED_FIELDS).execute();
    model.reset(feed.getItems());
    //375s3l4j6b7qnvhlhmt5d6kfog@group.calendar.google.com
    com.google.api.services.calendar.model.Events calendar = client.events()
            .list("netquest.com_ps7t0365jcsl0hlgnkq5kedbkg@group.calendar.google.com").execute();
//1htm7ep9ubatg154sk8ir98fvk@group.calendar.google.com
    Log.d("MARCELO", "Calendar Description: " + calendar.getSummary());

    for (com.google.api.services.calendar.model.Event event: calendar.getItems()) {
      Log.d("MARCELO", "------------------PISTAS DISPONIBLES-----------------------");
      Log.d("MARCELO", "Event Id:      " + event.getId());
      Log.d("MARCELO", "Event Summary: " + event.getSummary());
      Log.d("MARCELO", "Hora Inicio:   " + event.getStart().getDateTime().toString());
      Log.d("MARCELO", "Hora Fin:      " + event.getEnd().getDateTime().toString());
      Log.d("MARCELO", "------------------------------------------------------------");
    }
  }

  public static void run(CalendarTestActivity calendarSample) {
    new AsyncLoadCalendars(calendarSample).execute();
  }
}
