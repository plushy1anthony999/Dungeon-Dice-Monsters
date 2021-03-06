package Dungeon;
import Dungeon.DungeonSpace.Color;

public final class DungeonPieceJ extends DungeonPiece {
	public DungeonPieceJ(Color color) {
		super(color, new int[] {1, 1});
		dungeonPiece = new DungeonSpace[][] {
			{null,				      new DungeonSpace(color), null			          },
			{new DungeonSpace(color), new DungeonSpace(color), null			          },
			{null, 				      new DungeonSpace(color), new DungeonSpace(color)},
			{null, 				      null, 			       new DungeonSpace(color)}
		};
	}
}

/*  Dungeon Piece J */
//	     ----
//	     |  |
//	  ---|--|
//	  |  |XX|
//	  ---|--|--- 
//	     |  |  | 
//	     ---|--- 
//	        |  |
//	        ----

//XX is the spot where a monster is when their summoned 
//and the Dungeon piece is placed into the dungeon grid