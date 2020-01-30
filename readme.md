[![Build Status](https://travis-ci.org/mderouet/chess-spring-server.svg?branch=master)](https://travis-ci.org/mderouet/chess-spring-server)
[![codecov](https://codecov.io/gh/mderouet/chess-spring-server/branch/master/graph/badge.svg)](https://codecov.io/gh/mderouet/chess-spring-server)


# Chess game server


Rook moves improvement ideas :
For now we are building an array of all possible moves, it would be better to :
Depending to the couple "Departure Position && Arrival position" asked by the client, find the direction to check. Example:

My rook is A2, and the client wants to move this rook to H2 :
Then the direction we need to check is obviously the right, then, check whether there are pieces in it, if it's friendly pieces etc..

And reorganize packages

[<img src="https://i.imgur.com/rtnGyIH.png">](chess)
