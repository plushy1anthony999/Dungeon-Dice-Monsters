package Dungeon;

public final class DungeonPieceC extends DungeonPiece {
	protected final DungeonSpace[][] dungeonPiece; // The piece is a non-rectangular 2D Array

	public DungeonPieceC() {
		super();
		dungeonPiece = new DungeonSpace[][] {
			{new DungeonSpace(), new DungeonSpace(), null			   },
			{null, 				 new DungeonSpace(), null			   },
			{null, 				 new DungeonSpace(), new DungeonSpace()},
			{null, 				 new DungeonSpace(), null			   }
		};
	}
}

/*  Dungeon Piece C */
//	  -------
//	  |  |  |
//	  ---|--|
//	     |  |
//	     |--|---
//	     |  |  |
//	     |--|---
//	     |  |
//	     ----