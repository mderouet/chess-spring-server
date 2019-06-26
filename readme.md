# Chess game server


Rook moves improvement ideas :
For now we are building an array of all possible moves, it would be better to :
Depending to the couple "Departure Position && Arrival position" asked by the client, it would be interesting to find the direction to check. Example:

My rook is A2, and the client want to move this rook to H2 :
Then the direction we need to check is obviously the right, then, check whether there are pieces in it, if it's friendly pieces etc..
