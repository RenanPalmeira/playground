package com.playground.twitter

import com.google.inject.Stage
import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest


class MusicStartupTest extends FeatureTest {

  override val server = new EmbeddedHttpServer(
    twitterServer = new MusicServer,
    stage = Stage.PRODUCTION,
    verbose = false
  )

  test("Server#startup") {
    server.assertHealthy()
  }

}
