package com.playground.twitter.controller

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

import com.google.inject.{ Singleton, Inject }

import com.playground.twitter.service.PlaylistService


@Singleton
class PlaylistController @Inject() (playlistService: PlaylistService) extends Controller {

  get("/playlist/:playlist_id") { request: Request =>
    info("hi")
    "Listen " + request.params.getOrElse("name", "oasis")
  }

  get("/playlist") { request: Request => 
    playlistService.findAll()
  }
}
