package com.playground.twitter

import com.twitter.finagle.http.Status._
import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest


class PlaylistFeatureTest extends FeatureTest {

  override val server = new EmbeddedHttpServer(new MusicServer)

  test("Server#Say hi") {
    server.httpGet(
      path = "/playlist?name=Bob",
      andExpect = Ok,
      withBody = "{\"playlist_id\":1,\"name\":\"geroudo\"}")
  }

}
