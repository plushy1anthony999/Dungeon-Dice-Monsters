package Dungeon;
import Dungeon.DungeonSpace.Color;

public final class DungeonPieceD extends DungeonPiece {
	public DungeonPieceD(Color color) {
		super(color);
		dungeonPiece = new DungeonSpace[][] {
			{new DungeonSpace(color), new DungeonSpace(color), null			          },
			{null, 				      new DungeonSpace(color), null			          },
			{null, 				      new DungeonSpace(color), null			          },
			{null, 				      new DungeonSpace(color), new DungeonSpace(color)}
		};
	}
}

/*  Dungeon Piece D */
//	  -------
//	  |  |  |
//	  ---|--|
//	     |XX|
//	     |--|
//	     |  |
//	     |--|---
//	     |  |  |
//	     -------

//XX is the spot where a monster is when their summoned 
//and the Dungeon piece is placed into the dungeon grid