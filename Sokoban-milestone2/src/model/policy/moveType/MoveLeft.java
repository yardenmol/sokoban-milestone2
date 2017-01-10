package moveType;

import elements.Position;

public class MoveLeft implements IMoveType {

	/**
	 * return the decreased position (x,y-1)
	 */
	@Override
	public Position getNextPosition(Position pos) {
		return new Position(pos.getX(), pos.getY()-1);
	}

}
