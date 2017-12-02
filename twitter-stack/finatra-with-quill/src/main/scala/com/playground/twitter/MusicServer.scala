package com.playground.twitter

import com.twitter.finagle.http.{Request, Response}
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.{CommonFilters, LoggingMDCFilter, TraceIdMDCFilter}
import com.twitter.finatra.http.routing.HttpRouter
import com.playground.twitter.modules._

import com.playground.twitter.controller.{PlaylistController}

object MusicServerMain extends MusicServer

class MusicServer extends HttpServer {

  override def modules = Seq(DatabaseModule)

  override def configureHttp(router: HttpRouter) {
    router
      .filter[LoggingMDCFilter[Request, Response]]
      .filter[TraceIdMDCFilter[Request, Response]]
      .filter[CommonFilters]
      .add[PlaylistController]
  }
}
