package Dungeon;

public final class DungeonPieceF extends DungeonPiece {
	protected final DungeonSpace[][] dungeonPiece; // The piece is a non-rectangular 2D Array

	public DungeonPieceF() {
		super();
		dungeonPiece = new DungeonSpace[][] {
			{null, 				 new DungeonSpace(), null			   },
			{new DungeonSpace(), new DungeonSpace(), null			   },
			{null, 				 new DungeonSpace(), new DungeonSpace()},
			{null, 				 new DungeonSpace(), null			   }
		};
	}
}

/*  Dungeon Piece F */
//	     ----
//	     |  |
//	  ---|--|
//	  |  |  |
//	  ---|--|--- 
//	     |  |  | 
//	     |--|--- 
//	     |  |
//	     ----