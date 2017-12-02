package com.playground.twitter.service

import com.twitter.util.{ Future, FuturePool }

import com.google.inject.Inject
import com.google.inject.Singleton

import com.playground.twitter.modules.DatabaseModule.DatabaseSource
import com.playground.twitter.domain.Playlist


@Singleton
class PlaylistService @Inject() (val ctx: DatabaseSource) {

    import ctx._

    def findAll(): Future[Option[Playlist]] = FuturePool.unboundedPool {
        val q = quote {
          query[Playlist].take(1)
        }

        ctx.run(q).headOption
    }

}
