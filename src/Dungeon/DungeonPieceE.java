package Dungeon;

public final class DungeonPieceE extends DungeonPiece {
	protected final DungeonSpace[][] dungeonPiece; // The piece is a non-rectangular 2D Array

	public DungeonPieceE() {
		super();
		dungeonPiece = new DungeonSpace[][] {
			{null, 				 new DungeonSpace(), null			   },
			{new DungeonSpace(), new DungeonSpace(), new DungeonSpace()},
			{null, 				 new DungeonSpace(), null			   },
			{null, 				 new DungeonSpace(), null			   }
		};
	}
}

/*  Dungeon Piece E */
//	     ----
//	     |  |
//	  ---|--|--- 
//	  |  |  |  | 
//	  ---|--|--- 
//	     |  |
//	     |--|
//	     |  |
//	     ----