package com.katebeavis.tubespotter.data.local.seed

/**
 * Approximate Beck diagram positions on a 1000x1000 normalised grid.
 * x increases east, y increases south.
 * Values are (x, y) pairs keyed by station ID.
 */
object StationCoordinates {

    val coordinates: Map<Int, Pair<Float, Float>> = mapOf(

        // --- Bakerloo ---
        1 to Pair(230f, 95f),    // Harrow & Wealdstone
        2 to Pair(240f, 120f),   // Kenton
        3 to Pair(245f, 140f),   // South Kenton
        4 to Pair(250f, 160f),   // North Wembley
        5 to Pair(255f, 180f),   // Wembley Central
        6 to Pair(265f, 210f),   // Stonebridge Park
        7 to Pair(270f, 230f),   // Harlesden
        8 to Pair(270f, 250f),   // Willesden Junction
        9 to Pair(275f, 275f),   // Kensal Green
        10 to Pair(270f, 300f),  // Queen's Park
        11 to Pair(270f, 320f),  // Kilburn Park
        12 to Pair(270f, 345f),  // Maida Vale
        13 to Pair(270f, 370f),  // Warwick Avenue
        14 to Pair(305f, 385f),  // Marylebone
        15 to Pair(345f, 420f),  // Regent's Park
        16 to Pair(430f, 520f),  // Lambeth North

        // --- Shared: Bakerloo / Circle / District / Met / H&C ---
        17 to Pair(285f, 415f),  // Paddington
        18 to Pair(300f, 430f),  // Edgware Road
        19 to Pair(340f, 400f),  // Baker Street
        20 to Pair(400f, 435f),  // Oxford Circus
        21 to Pair(415f, 460f),  // Piccadilly Circus
        22 to Pair(420f, 475f),  // Charing Cross
        23 to Pair(455f, 490f),  // Embankment
        24 to Pair(470f, 500f),  // Waterloo
        25 to Pair(465f, 540f),  // Elephant & Castle

        // --- Central (eastern branches) ---
        26 to Pair(935f, 80f),   // Epping
        27 to Pair(915f, 105f),  // Theydon Bois
        28 to Pair(895f, 125f),  // Debden
        29 to Pair(875f, 145f),  // Loughton
        30 to Pair(855f, 160f),  // Buckhurst Hill
        31 to Pair(855f, 185f),  // Chigwell
        32 to Pair(820f, 220f),  // Grange Hill
        33 to Pair(830f, 200f),  // Hainault
        34 to Pair(820f, 240f),  // Fairlop
        35 to Pair(820f, 260f),  // Barkingside
        36 to Pair(805f, 275f),  // Newbury Park
        37 to Pair(835f, 145f),  // Woodford
        38 to Pair(835f, 170f),  // Roding Valley
        39 to Pair(805f, 165f),  // Snaresbrook
        40 to Pair(805f, 185f),  // South Woodford
        41 to Pair(790f, 225f),  // Wanstead
        42 to Pair(775f, 250f),  // Redbridge
        43 to Pair(760f, 270f),  // Gants Hill
        44 to Pair(745f, 320f),  // Leyton
        45 to Pair(775f, 295f),  // Leytonstone
        46 to Pair(650f, 355f),  // Bethnal Green
        47 to Pair(585f, 390f),  // St Paul's
        48 to Pair(555f, 390f),  // Chancery Lane
        49 to Pair(490f, 400f),  // Tottenham Court Road
        50 to Pair(385f, 430f),  // Bond Street
        51 to Pair(360f, 445f),  // Marble Arch
        52 to Pair(335f, 450f),  // Lancaster Gate
        53 to Pair(315f, 455f),  // Queensway
        54 to Pair(270f, 460f),  // Holland Park
        55 to Pair(240f, 455f),  // White City
        56 to Pair(215f, 460f),  // East Acton
        57 to Pair(195f, 445f),  // North Acton
        58 to Pair(175f, 450f),  // West Acton
        59 to Pair(155f, 455f),  // Ealing Broadway
        60 to Pair(170f, 475f),  // Ealing Common
        61 to Pair(200f, 465f),  // Hanger Lane
        62 to Pair(185f, 480f),  // Perivale
        63 to Pair(165f, 480f),  // Greenford
        64 to Pair(145f, 480f),  // Northolt
        65 to Pair(125f, 480f),  // South Ruislip
        66 to Pair(105f, 480f),  // Ruislip Gardens
        67 to Pair(85f, 480f),   // West Ruislip

        // --- Shared: Central / Circle / H&C ---
        68 to Pair(245f, 455f),  // Shepherd's Bush Market
        69 to Pair(255f, 445f),  // Wood Lane
        70 to Pair(265f, 435f),  // Latimer Road
        71 to Pair(295f, 455f),  // Notting Hill Gate
        72 to Pair(615f, 370f),  // Liverpool Street
        73 to Pair(580f, 415f),  // Bank
        74 to Pair(530f, 395f),  // Holborn
        75 to Pair(710f, 360f),  // Stratford
        76 to Pair(670f, 385f),  // Mile End

        // --- Circle / District / H&C ---
        77 to Pair(235f, 495f),  // Hammersmith
        78 to Pair(220f, 510f),  // Ravenscourt Park
        79 to Pair(205f, 520f),  // Stamford Brook
        80 to Pair(190f, 520f),  // Turnham Green
        81 to Pair(175f, 525f),  // Gunnersbury
        82 to Pair(155f, 535f),  // Kew Gardens
        83 to Pair(135f, 540f),  // Richmond
        84 to Pair(250f, 635f),  // Wimbledon
        85 to Pair(265f, 610f),  // Wimbledon Park
        86 to Pair(280f, 585f),  // Southfields
        87 to Pair(290f, 560f),  // East Putney
        88 to Pair(295f, 540f),  // Putney Bridge
        89 to Pair(300f, 520f),  // Parsons Green
        90 to Pair(305f, 510f),  // Fulham Broadway
        91 to Pair(300f, 500f),  // West Brompton
        92 to Pair(295f, 495f),  // Earl's Court
        93 to Pair(270f, 490f),  // Kensington Olympia
        94 to Pair(305f, 475f),  // High Street Kensington
        95 to Pair(325f, 490f),  // Gloucester Road
        96 to Pair(345f, 490f),  // South Kensington
        97 to Pair(385f, 495f),  // Sloane Square
        98 to Pair(405f, 490f),  // Victoria
        99 to Pair(430f, 490f),  // St James's Park
        100 to Pair(445f, 490f), // Westminster
        101 to Pair(470f, 490f), // Temple
        102 to Pair(490f, 490f), // Blackfriars
        103 to Pair(510f, 490f), // Mansion House
        104 to Pair(535f, 490f), // Cannon Street
        105 to Pair(555f, 490f), // Monument
        106 to Pair(575f, 490f), // Tower Hill
        107 to Pair(600f, 385f), // Aldgate
        108 to Pair(615f, 400f), // Aldgate East
        109 to Pair(630f, 415f), // Whitechapel
        110 to Pair(648f, 425f), // Stepney Green
        111 to Pair(662f, 400f), // Bow Road
        112 to Pair(677f, 408f), // Bromley-by-Bow
        113 to Pair(700f, 418f), // West Ham
        114 to Pair(718f, 432f), // Plaistow
        115 to Pair(735f, 442f), // Upton Park
        116 to Pair(752f, 452f), // East Ham
        117 to Pair(770f, 458f), // Barking
        118 to Pair(785f, 462f), // Upney
        119 to Pair(800f, 466f), // Becontree
        120 to Pair(815f, 470f), // Dagenham Heathway
        121 to Pair(830f, 474f), // Dagenham East
        122 to Pair(845f, 478f), // Elm Park
        123 to Pair(860f, 482f), // Hornchurch
        124 to Pair(875f, 486f), // Upminster Bridge
        125 to Pair(892f, 486f), // Upminster
        126 to Pair(300f, 455f), // Bayswater
        127 to Pair(235f, 465f), // Goldhawk Road
        128 to Pair(490f, 335f), // King's Cross St. Pancras
        129 to Pair(510f, 390f), // Farringdon
        130 to Pair(545f, 385f), // Barbican
        131 to Pair(575f, 378f), // Moorgate
        132 to Pair(375f, 415f), // Euston Square
        133 to Pair(358f, 410f), // Great Portland Street

        // --- Jubilee ---
        134 to Pair(370f, 95f),  // Stanmore
        135 to Pair(375f, 120f), // Canons Park
        136 to Pair(380f, 150f), // Queensbury
        137 to Pair(385f, 175f), // Kingsbury
        138 to Pair(395f, 200f), // Wembley Park
        139 to Pair(390f, 235f), // Neasden
        140 to Pair(385f, 255f), // Dollis Hill
        141 to Pair(380f, 278f), // Willesden Green
        142 to Pair(372f, 298f), // Kilburn
        143 to Pair(365f, 318f), // West Hampstead
        144 to Pair(358f, 338f), // Finchley Road
        145 to Pair(352f, 358f), // Swiss Cottage
        146 to Pair(348f, 378f), // St John's Wood
        147 to Pair(490f, 515f), // Southwark
        148 to Pair(540f, 510f), // London Bridge
        149 to Pair(555f, 540f), // Bermondsey
        150 to Pair(570f, 565f), // Canada Water
        151 to Pair(610f, 560f), // Canary Wharf
        152 to Pair(650f, 558f), // North Greenwich
        153 to Pair(690f, 542f), // Canning Town

        // --- Shared: Jubilee / Victoria / Northern ---
        154 to Pair(405f, 465f), // Green Park
        155 to Pair(435f, 395f), // Warren Street
        156 to Pair(460f, 365f), // Euston

        // --- Metropolitan ---
        157 to Pair(70f, 210f),  // Chorleywood
        158 to Pair(60f, 165f),  // Watford
        159 to Pair(45f, 145f),  // Amersham
        160 to Pair(40f, 95f),   // Chesham
        161 to Pair(55f, 170f),  // Chalfont & Latimer
        162 to Pair(80f, 222f),  // Rickmansworth
        163 to Pair(95f, 252f),  // Moor Park
        164 to Pair(105f, 278f), // Northwood
        165 to Pair(112f, 305f), // Northwood Hills
        166 to Pair(122f, 330f), // Pinner
        167 to Pair(132f, 352f), // North Harrow
        168 to Pair(148f, 368f), // Harrow-on-the-Hill
        169 to Pair(152f, 375f), // West Harrow
        170 to Pair(165f, 388f), // Rayners Lane
        171 to Pair(178f, 398f), // Eastcote
        172 to Pair(115f, 398f), // Ruislip Manor
        173 to Pair(100f, 412f), // Ruislip
        174 to Pair(100f, 432f), // Ickenham
        175 to Pair(90f, 448f),  // Hillingdon
        176 to Pair(75f, 458f),  // Uxbridge
        177 to Pair(360f, 215f), // Preston Road
        178 to Pair(355f, 238f), // Northwick Park

        // --- Northern (Edgware branch) ---
        180 to Pair(430f, 85f),  // Edgware
        181 to Pair(435f, 115f), // Burnt Oak
        182 to Pair(440f, 140f), // Colindale
        183 to Pair(445f, 165f), // Hendon Central
        184 to Pair(450f, 190f), // Brent Cross
        185 to Pair(455f, 215f), // Golders Green
        186 to Pair(460f, 245f), // Hampstead
        187 to Pair(462f, 270f), // Belsize Park
        188 to Pair(462f, 295f), // Chalk Farm
        189 to Pair(462f, 320f), // Camden Town
        190 to Pair(462f, 355f), // Mornington Crescent
        191 to Pair(462f, 410f), // Goodge Street
        192 to Pair(445f, 450f), // Leicester Square
        193 to Pair(530f, 530f), // Borough
        194 to Pair(500f, 555f), // Kennington
        195 to Pair(490f, 580f), // Oval
        196 to Pair(480f, 600f), // Stockwell
        197 to Pair(475f, 622f), // Clapham North
        198 to Pair(470f, 642f), // Clapham Common
        199 to Pair(465f, 662f), // Clapham South
        200 to Pair(460f, 682f), // Balham
        201 to Pair(455f, 702f), // Tooting Bec
        202 to Pair(450f, 722f), // Tooting Broadway
        203 to Pair(445f, 742f), // Colliers Wood
        204 to Pair(440f, 762f), // South Wimbledon
        205 to Pair(435f, 782f), // Morden

        // --- Northern (High Barnet branch) ---
        206 to Pair(510f, 80f),  // High Barnet
        207 to Pair(510f, 110f), // Totteridge & Whetstone
        208 to Pair(510f, 135f), // Woodside Park
        209 to Pair(510f, 160f), // West Finchley
        210 to Pair(510f, 185f), // Finchley Central
        211 to Pair(510f, 215f), // East Finchley
        212 to Pair(505f, 245f), // Highgate
        213 to Pair(500f, 270f), // Archway
        214 to Pair(492f, 298f), // Tufnell Park
        215 to Pair(482f, 325f), // Kentish Town
        216 to Pair(532f, 378f), // Angel
        217 to Pair(542f, 362f), // Old Street

        // --- Piccadilly (north / Cockfosters branch) ---
        219 to Pair(595f, 80f),  // Cockfosters
        220 to Pair(585f, 110f), // Oakwood
        221 to Pair(575f, 140f), // Southgate
        222 to Pair(565f, 165f), // Arnos Grove
        223 to Pair(555f, 190f), // Bounds Green
        224 to Pair(545f, 215f), // Wood Green
        225 to Pair(535f, 242f), // Turnpike Lane
        226 to Pair(525f, 268f), // Manor House
        227 to Pair(505f, 318f), // Arsenal
        228 to Pair(500f, 342f), // Holloway Road
        229 to Pair(495f, 362f), // Caledonian Road
        230 to Pair(502f, 412f), // Russell Square
        231 to Pair(445f, 455f), // Covent Garden
        232 to Pair(400f, 475f), // Hyde Park Corner
        233 to Pair(362f, 475f), // Knightsbridge
        234 to Pair(278f, 505f), // Barons Court
        235 to Pair(215f, 510f), // Acton Town
        236 to Pair(208f, 530f), // Chiswick Park

        // --- Piccadilly (Heathrow branch) ---
        237 to Pair(88f, 532f),  // Heathrow Terminal 5
        238 to Pair(78f, 548f),  // Heathrow Terminals 2 & 3
        239 to Pair(88f, 562f),  // Heathrow Terminal 4
        240 to Pair(118f, 558f), // Hatton Cross
        241 to Pair(140f, 558f), // Hounslow West
        242 to Pair(162f, 558f), // Hounslow Central
        243 to Pair(183f, 558f), // Hounslow East
        244 to Pair(200f, 548f), // Osterley
        245 to Pair(210f, 538f), // Boston Manor
        246 to Pair(195f, 512f), // Northfields
        247 to Pair(198f, 500f), // South Ealing

        // --- Piccadilly (Uxbridge / Heathrow via Rayners Lane branch) ---
        248 to Pair(190f, 492f), // South Harrow
        249 to Pair(183f, 502f), // Sudbury Hill
        250 to Pair(192f, 512f), // Sudbury Town
        251 to Pair(207f, 512f), // Alperton
        252 to Pair(222f, 502f), // Park Royal
        253 to Pair(212f, 492f), // North Ealing

        // --- Shared: Piccadilly / Victoria ---
        254 to Pair(530f, 288f), // Finsbury Park

        // --- Victoria ---
        256 to Pair(450f, 662f), // Brixton
        257 to Pair(442f, 530f), // Vauxhall
        258 to Pair(415f, 510f), // Pimlico
        259 to Pair(532f, 308f), // Highbury & Islington
        260 to Pair(548f, 248f), // Seven Sisters
        261 to Pair(556f, 272f), // Tottenham Hale
        262 to Pair(562f, 298f), // Blackhorse Road
        263 to Pair(568f, 322f), // Walthamstow Central
    )
}
