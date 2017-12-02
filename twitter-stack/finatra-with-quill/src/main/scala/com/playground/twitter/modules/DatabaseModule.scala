package com.playground.twitter.modules

import com.google.inject.{ Provides, Singleton }
import com.twitter.inject.TwitterModule
import io.getquill.{ PostgresJdbcContext, SnakeCase }


object DatabaseModule extends TwitterModule {

  type DatabaseSource = PostgresJdbcContext[SnakeCase]

  @Provides
  @Singleton
  def provideDataBaseSource: DatabaseSource =
    new PostgresJdbcContext(SnakeCase, "ctx")

}