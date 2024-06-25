Welcome to **MapGenForInvictus**! This backend service generates a JSON object, which is subsequently used by the frontend of my game, **Invictus**, to create and display a map. 

## Overview

The core functionality of MapGenForInvictus is to create a structured JSON object that represents the map of the game. The map is a collection of tile objects, each containing:

- **position:** This includes the `x` and `y` coordinates of the tile on the map.
- **type:** This is a descriptor that tells the game which PNG image to render for that specific tile location.

## JSON Object Structure

The generated JSON object, referred to as `map`, follows this structure:

```json
{
  "map": [
    {
      "position": {
        "x": <x-coordinate>,
        "y": <y-coordinate>
      },
      "type": "<tile-type>"
    },
    ...
  ]
}
```

Each tile object within the `map` array includes:

- **position:** An object containing:
  - `x` (integer): The X-coordinate of the tile.
  - `y` (integer): The Y-coordinate of the tile.
  
- **type:** A string that denotes the type of the tile. This type is used by the game engine to determine which PNG image should be displayed for the tile.

## How It Works

1. **Data Generation:**
   - The backend script generates an array of tile objects. Each tile object includes an `x` and `y` coordinate and a `type` assigned based on your game's logic.

2. **JSON Output:**
   - Once all tiles are generated, the array is serialized into a JSON object. This JSON object is then consumed by the frontend to render the map accordingly.

## Example

Here’s a sample JSON output for a simple map:

```json
{
  "map": [
    {
      "position": {
        "x": 0,
        "y": 0
      },
      "type": "grass"
    },
    {
      "position": {
        "x": 1,
        "y": 0
      },
      "type": "water"
    },
    {
      "position": {
        "x": 0,
        "y": 1
      },
      "type": "sand"
    }
  ]
}
```

In this example:
- The tile at position (0, 0) is of type `grass`.
- The tile at position (1, 0) is of type `water`.
- The tile at position (0, 1) is of type `sand`.
