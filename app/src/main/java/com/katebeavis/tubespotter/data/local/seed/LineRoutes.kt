package com.katebeavis.tubespotter.data.local.seed

/**
 * Ordered station sequences per line for drawing map paths.
 * Each list represents a continuous segment from one terminus to another.
 * Branching lines have multiple segments.
 */
object LineRoutes {

    // lineId -> list of segments, each segment is an ordered list of station IDs
    val segments: Map<Int, List<List<Int>>> = mapOf(

        // Bakerloo (1) — Harrow & Wealdstone to Elephant & Castle
        1 to listOf(
            listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 17, 18, 19, 14, 15, 20, 21, 22, 23, 24, 16, 25)
        ),

        // Central (2) — multiple branches
        2 to listOf(
            // West Ruislip to Ealing Broadway (west branch)
            listOf(67, 66, 65, 64, 63, 62, 61, 60, 59),
            // Ealing Broadway through central to Stratford/Epping (main)
            listOf(59, 58, 57, 56, 55, 54, 71, 53, 52, 51, 50, 20, 49, 74, 48, 47, 73, 72, 46, 76, 75),
            // Hanger Lane branch
            listOf(61, 57),
            // Woodford to Hainault loop
            listOf(37, 38, 33, 32, 34, 35, 36, 45, 44, 75),
            // Woodford to Epping
            listOf(37, 30, 29, 28, 27, 26),
            // Snaresbrook branch
            listOf(39, 40, 41, 42, 43, 45),
            // Shepherd's Bush branch
            listOf(68, 69, 70, 71),
        ),

        // Circle (3) — loop with H&C overlap
        3 to listOf(
            listOf(17, 126, 71, 94, 95, 96, 97, 98, 99, 100, 23, 101, 102, 103, 104, 105, 106, 107, 131, 130, 72, 129, 128, 132, 133, 19, 18, 17),
            listOf(19, 68, 69, 70, 77),
            listOf(77, 78, 79, 80),
        ),

        // District (4) — multiple branches
        4 to listOf(
            // Richmond branch
            listOf(83, 82, 81, 80, 79, 78, 77, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84),
            // Wimbledon to Earl's Court
            listOf(84, 85, 86, 87, 88, 89, 90, 91, 92),
            // Earl's Court to Tower Hill
            listOf(92, 94, 95, 96, 97, 98, 99, 100, 23, 102, 103, 104, 105, 106),
            // Earl's Court to Edgware Road via Paddington
            listOf(92, 71, 17, 18),
            // Tower Hill to Upminster
            listOf(106, 108, 109, 110, 76, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125),
            // Acton Town branch
            listOf(235, 236, 81),
            listOf(59, 60, 235),
        ),

        // Hammersmith & City (5)
        5 to listOf(
            listOf(77, 127, 68, 69, 70, 71, 126, 17, 18, 19, 132, 133, 128, 129, 130, 131, 72, 108, 109, 110, 76, 111, 112, 113, 117),
        ),

        // Jubilee (6) — Stanmore to Stratford
        6 to listOf(
            listOf(134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 19, 50, 154, 100, 24, 147, 148, 149, 150, 151, 152, 153, 113, 75),
        ),

        // Metropolitan (7) — multiple branches
        7 to listOf(
            // Aldgate to Baker Street
            listOf(107, 131, 130, 72, 129, 128, 132, 133, 19),
            // Baker Street to Amersham/Chesham
            listOf(19, 17, 178, 177, 138, 168, 167, 166, 165, 164, 163, 162, 157, 161, 159),
            // Chesham branch
            listOf(161, 160),
            // Watford branch
            listOf(162, 158),
            // Uxbridge branch
            listOf(168, 169, 170, 171, 172, 173, 174, 175, 176),
            // Harrow & Wealdstone branch
            listOf(1, 2, 168),
        ),

        // Northern (8) — complex Y shape
        8 to listOf(
            // Edgware branch
            listOf(180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 156, 155, 191, 49, 192, 22, 23, 24, 148, 193, 25, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205),
            // High Barnet branch
            listOf(206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 189),
            // Bank branch (City)
            listOf(156, 216, 217, 131, 73, 148),
            // Mornington Crescent junction
            listOf(189, 190),
        ),

        // Piccadilly (9) — multiple branches
        9 to listOf(
            // Cockfosters to central
            listOf(219, 220, 221, 222, 223, 224, 225, 226, 254, 227, 228, 229, 128, 230, 74, 231, 192, 21, 154, 232, 233, 96, 95, 92, 234, 77, 235),
            // Heathrow branch
            listOf(235, 246, 247, 244, 245, 243, 242, 241, 240, 238, 237),
            // Terminal 4 spur
            listOf(240, 239),
            // Uxbridge branch via South Harrow
            listOf(235, 253, 252, 251, 250, 249, 248, 170, 64),
            // Richmond branch
            listOf(77, 236, 81, 82, 83),
        ),

        // Victoria (10) — Brixton to Walthamstow Central
        10 to listOf(
            listOf(256, 196, 257, 258, 98, 154, 20, 155, 156, 128, 259, 254, 260, 261, 262, 263),
        ),

        // Waterloo & City (11) — Waterloo to Bank
        11 to listOf(
            listOf(24, 73),
        ),
    )
}
