package Dungeon;

public final class DungeonPieceA extends DungeonPiece {
	protected final DungeonSpace[][] dungeonPiece; // The piece is a non-rectangular 2D Array

	public DungeonPieceA() {
		super();
		dungeonPiece = new DungeonSpace[][] {
			{new DungeonSpace(), new DungeonSpace(), new DungeonSpace()},
			{null, 				 new DungeonSpace(), null			   },
			{null, 				 new DungeonSpace(), null			   },
			{null, 				 new DungeonSpace(), null			   }
		};
	}
}

/*  Dungeon Piece A */
//	  ----------
//	  |  |  |  |
//	  ---|--|---
//	     |  |
//	     |--|
//	     |  |
//	     |--|
//	     |  |
//	     ----