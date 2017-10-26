package Dungeon;
import Dungeon.DungeonSpace.Color;

public final class DungeonPieceH extends DungeonPiece {
	public DungeonPieceH(Color color) {
		super(color);
		dungeonPiece = new DungeonSpace[][] {
			{null,				      new DungeonSpace(color), null			   },
			{null,				      new DungeonSpace(color), null			   },
			{new DungeonSpace(color), new DungeonSpace(color), null			   },
			{new DungeonSpace(color), null, 				   null			   },
			{new DungeonSpace(color), null, 				   null			   }
		};
	}
}

/*  Dungeon Piece H */
//	     ----
//	     |  |
//	     |--|
//	     |  |
//	  ---|--|
//	  |XX|  |
//	  |--|---
//	  |  |    
//	  |--|      
//	  |  |
//	  |--|

//XX is the spot where a monster is when their summoned 
//and the Dungeon piece is placed into the dungeon grid