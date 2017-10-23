package Dungeon;

public final class DungeonPieceD extends DungeonPiece {
	protected final DungeonSpace[][] dungeonPiece; // The piece is a non-rectangular 2D Array

	public DungeonPieceD() {
		super();
		dungeonPiece = new DungeonSpace[][] {
			{new DungeonSpace(), new DungeonSpace(), null			   },
			{null, 				 new DungeonSpace(), null			   },
			{null, 				 new DungeonSpace(), null			   },
			{null, 				 new DungeonSpace(), new DungeonSpace()}
		};
	}
}

/*  Dungeon Piece D */
//	  -------
//	  |  |  |
//	  ---|--|
//	     |  |
//	     |--|
//	     |  |
//	     |--|---
//	     |  |  |
//	     -------