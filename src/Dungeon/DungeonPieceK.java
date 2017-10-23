package Dungeon;

public final class DungeonPieceK extends DungeonPiece {
	protected final DungeonSpace[][] dungeonPiece; // The piece is a non-rectangular 2D Array

	public DungeonPieceK() {
		super();
		dungeonPiece = new DungeonSpace[][] {
			{new DungeonSpace(), null,				 null			   },
			{new DungeonSpace(), new DungeonSpace(), null			   },
			{null, 				 new DungeonSpace(), new DungeonSpace()},
			{null, 				 null, 				 new DungeonSpace()}
		};
	}
}

/*  Dungeon Piece K */
//	  ----
//	  |  |
//	  ---|--|
//	  |  |  |
//	  ---|--|--- 
//	     |  |  | 
//	     ---|--- 
//	        |  |
//	        ----