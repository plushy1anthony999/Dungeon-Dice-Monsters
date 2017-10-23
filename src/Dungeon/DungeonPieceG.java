package Dungeon;

public final class DungeonPieceG extends DungeonPiece {
	protected final DungeonSpace[][] dungeonPiece; // The piece is a non-rectangular 2D Array

	public DungeonPieceG() {
		super();
		dungeonPiece = new DungeonSpace[][] {
			{new DungeonSpace(), new DungeonSpace(), null			   },
			{null,				 new DungeonSpace(), null			   },
			{null, 				 new DungeonSpace(), new DungeonSpace()},
			{null, 				 null, 				 new DungeonSpace()}
		};
	}
}

/*  Dungeon Piece G */
//	  -------
//	  |  |  |
//	  ---|--|
//	     |  |
//	     |--|--- 
//	     |  |  | 
//	     ---|--- 
//	        |  |
//	        ----