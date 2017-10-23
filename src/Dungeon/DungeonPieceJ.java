package Dungeon;

public final class DungeonPieceJ extends DungeonPiece {
	protected final DungeonSpace[][] dungeonPiece; // The piece is a non-rectangular 2D Array

	public DungeonPieceJ() {
		super();
		dungeonPiece = new DungeonSpace[][] {
			{null,				 new DungeonSpace(), null			   },
			{new DungeonSpace(), new DungeonSpace(), null			   },
			{null, 				 new DungeonSpace(), new DungeonSpace()},
			{null, 				 null, 				 new DungeonSpace()}
		};
	}
}

/*  Dungeon Piece J */
//	     ----
//	     |  |
//	  ---|--|
//	  |  |  |
//	  ---|--|--- 
//	     |  |  | 
//	     ---|--- 
//	        |  |
//	        ----