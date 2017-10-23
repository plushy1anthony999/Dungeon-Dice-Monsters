package Dungeon;

public final class DungeonPieceH extends DungeonPiece {
	protected final DungeonSpace[][] dungeonPiece; // The piece is a non-rectangular 2D Array

	public DungeonPieceH() {
		super();
		dungeonPiece = new DungeonSpace[][] {
			{null,				 new DungeonSpace(), null			   },
			{null,				 new DungeonSpace(), null			   },
			{new DungeonSpace(), new DungeonSpace(), null			   },
			{new DungeonSpace(), null, 				 null			   },
			{new DungeonSpace(), null, 				 null			   }
		};
	}
}

/*  Dungeon Piece H */
//	     ----
//	     |  |
//	     |--|
//	     |  |
//	  ---|--|
//	  |  |  |
//	  |--|---
//	  |  |    
//	  |--|      
//	  |  |
//	  |--|