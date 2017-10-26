package Dungeon;
import Dungeon.DungeonSpace.Color;

public final class DungeonPieceE extends DungeonPiece {
	public DungeonPieceE(Color color) {
		super(color);
		dungeonPiece = new DungeonSpace[][] {
			{null, 				      new DungeonSpace(color), null			          },
			{new DungeonSpace(color), new DungeonSpace(color), new DungeonSpace(color)},
			{null, 				      new DungeonSpace(color), null			          },
			{null, 				      new DungeonSpace(color), null			          }
		};
	}
}

/*  Dungeon Piece E */
//	     ----
//	     |  |
//	  ---|--|--- 
//	  |  |XX|  | 
//	  ---|--|--- 
//	     |  |
//	     |--|
//	     |  |
//	     ----

//XX is the spot where a monster is when their summoned 
//and the Dungeon piece is placed into the dungeon grid