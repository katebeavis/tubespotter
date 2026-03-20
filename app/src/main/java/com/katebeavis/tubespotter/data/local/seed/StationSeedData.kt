package com.katebeavis.tubespotter.data.local.seed

import com.katebeavis.tubespotter.data.local.entity.LineEntity
import com.katebeavis.tubespotter.data.local.entity.StationEntity
import com.katebeavis.tubespotter.data.local.entity.StationLineCrossRef

object StationSeedData {

    val lines = listOf(
        LineEntity(id = 1, name = "Bakerloo", colour = "#B36305", displayOrder = 1),
        LineEntity(id = 2, name = "Central", colour = "#E32017", displayOrder = 2),
        LineEntity(id = 3, name = "Circle", colour = "#FFD300", displayOrder = 3),
        LineEntity(id = 4, name = "District", colour = "#00782A", displayOrder = 4),
        LineEntity(id = 5, name = "Hammersmith & City", colour = "#F3A9BB", displayOrder = 5),
        LineEntity(id = 6, name = "Jubilee", colour = "#A0A5A9", displayOrder = 6),
        LineEntity(id = 7, name = "Metropolitan", colour = "#9B0056", displayOrder = 7),
        LineEntity(id = 8, name = "Northern", colour = "#000000", displayOrder = 8),
        LineEntity(id = 9, name = "Piccadilly", colour = "#003688", displayOrder = 9),
        LineEntity(id = 10, name = "Victoria", colour = "#0098D4", displayOrder = 10),
        LineEntity(id = 11, name = "Waterloo & City", colour = "#95CDBA", displayOrder = 11),
    )

    val stations = listOf(
        // Bakerloo-only
        StationEntity(id = 1, name = "Harrow & Wealdstone", zone = "5"),
        StationEntity(id = 2, name = "Kenton", zone = "4"),
        StationEntity(id = 3, name = "South Kenton", zone = "4"),
        StationEntity(id = 4, name = "North Wembley", zone = "4"),
        StationEntity(id = 5, name = "Wembley Central", zone = "4"),
        StationEntity(id = 6, name = "Stonebridge Park", zone = "3"),
        StationEntity(id = 7, name = "Harlesden", zone = "3"),
        StationEntity(id = 8, name = "Willesden Junction", zone = "3"),
        StationEntity(id = 9, name = "Kensal Green", zone = "2"),
        StationEntity(id = 10, name = "Queen's Park", zone = "2"),
        StationEntity(id = 11, name = "Kilburn Park", zone = "2"),
        StationEntity(id = 12, name = "Maida Vale", zone = "2"),
        StationEntity(id = 13, name = "Warwick Avenue", zone = "2"),
        StationEntity(id = 14, name = "Marylebone", zone = "1"),
        StationEntity(id = 15, name = "Regent's Park", zone = "1"),
        StationEntity(id = 16, name = "Lambeth North", zone = "1"),

        // Shared: Bakerloo + others
        StationEntity(id = 17, name = "Paddington", zone = "1"),
        StationEntity(id = 18, name = "Edgware Road", zone = "1"),
        StationEntity(id = 19, name = "Baker Street", zone = "1"),
        StationEntity(id = 20, name = "Oxford Circus", zone = "1"),
        StationEntity(id = 21, name = "Piccadilly Circus", zone = "1"),
        StationEntity(id = 22, name = "Charing Cross", zone = "1"),
        StationEntity(id = 23, name = "Embankment", zone = "1"),
        StationEntity(id = 24, name = "Waterloo", zone = "1"),
        StationEntity(id = 25, name = "Elephant & Castle", zone = "1/2"),

        // Central-only
        StationEntity(id = 26, name = "Epping", zone = "6"),
        StationEntity(id = 27, name = "Theydon Bois", zone = "6"),
        StationEntity(id = 28, name = "Debden", zone = "6"),
        StationEntity(id = 29, name = "Loughton", zone = "4"),
        StationEntity(id = 30, name = "Buckhurst Hill", zone = "4"),
        StationEntity(id = 31, name = "Chigwell", zone = "4"),
        StationEntity(id = 32, name = "Grange Hill", zone = "4"),
        StationEntity(id = 33, name = "Hainault", zone = "4"),
        StationEntity(id = 34, name = "Fairlop", zone = "4"),
        StationEntity(id = 35, name = "Barkingside", zone = "4"),
        StationEntity(id = 36, name = "Newbury Park", zone = "4"),
        StationEntity(id = 37, name = "Woodford", zone = "4"),
        StationEntity(id = 38, name = "Roding Valley", zone = "4"),
        StationEntity(id = 39, name = "Snaresbrook", zone = "4"),
        StationEntity(id = 40, name = "South Woodford", zone = "3/4"),
        StationEntity(id = 41, name = "Wanstead", zone = "3/4"),
        StationEntity(id = 42, name = "Redbridge", zone = "3/4"),
        StationEntity(id = 43, name = "Gants Hill", zone = "3/4"),
        StationEntity(id = 44, name = "Leyton", zone = "3"),
        StationEntity(id = 45, name = "Leytonstone", zone = "3/4"),
        StationEntity(id = 46, name = "Bethnal Green", zone = "2"),
        StationEntity(id = 47, name = "St Paul's", zone = "1"),
        StationEntity(id = 48, name = "Chancery Lane", zone = "1"),
        StationEntity(id = 49, name = "Tottenham Court Road", zone = "1"),
        StationEntity(id = 50, name = "Bond Street", zone = "1"),
        StationEntity(id = 51, name = "Marble Arch", zone = "1"),
        StationEntity(id = 52, name = "Lancaster Gate", zone = "1"),
        StationEntity(id = 53, name = "Queensway", zone = "1"),
        StationEntity(id = 54, name = "Holland Park", zone = "2"),
        StationEntity(id = 55, name = "White City", zone = "2"),
        StationEntity(id = 56, name = "East Acton", zone = "2"),
        StationEntity(id = 57, name = "North Acton", zone = "3"),
        StationEntity(id = 58, name = "West Acton", zone = "3"),
        StationEntity(id = 59, name = "Ealing Broadway", zone = "3"),
        StationEntity(id = 60, name = "Ealing Common", zone = "3"),
        StationEntity(id = 61, name = "Hanger Lane", zone = "3"),
        StationEntity(id = 62, name = "Perivale", zone = "4"),
        StationEntity(id = 63, name = "Greenford", zone = "4"),
        StationEntity(id = 64, name = "Northolt", zone = "5"),
        StationEntity(id = 65, name = "South Ruislip", zone = "5"),
        StationEntity(id = 66, name = "Ruislip Gardens", zone = "5"),
        StationEntity(id = 67, name = "West Ruislip", zone = "6"),

        // Shared: Central + others
        StationEntity(id = 68, name = "Shepherd's Bush Market", zone = "2"),
        StationEntity(id = 69, name = "Wood Lane", zone = "2"),
        StationEntity(id = 70, name = "Latimer Road", zone = "2"),
        StationEntity(id = 71, name = "Notting Hill Gate", zone = "1/2"),
        StationEntity(id = 72, name = "Liverpool Street", zone = "1"),
        StationEntity(id = 73, name = "Bank", zone = "1"),
        StationEntity(id = 74, name = "Holborn", zone = "1"),
        StationEntity(id = 75, name = "Stratford", zone = "3"),
        StationEntity(id = 76, name = "Mile End", zone = "2"),

        // Circle/District/H&C shared
        StationEntity(id = 77, name = "Hammersmith", zone = "2"),
        StationEntity(id = 78, name = "Ravenscourt Park", zone = "2"),
        StationEntity(id = 79, name = "Stamford Brook", zone = "2"),
        StationEntity(id = 80, name = "Turnham Green", zone = "2/3"),
        StationEntity(id = 81, name = "Gunnersbury", zone = "3"),
        StationEntity(id = 82, name = "Kew Gardens", zone = "3/4"),
        StationEntity(id = 83, name = "Richmond", zone = "4"),
        StationEntity(id = 84, name = "Wimbledon", zone = "3"),
        StationEntity(id = 85, name = "Wimbledon Park", zone = "3"),
        StationEntity(id = 86, name = "Southfields", zone = "3"),
        StationEntity(id = 87, name = "East Putney", zone = "3"),
        StationEntity(id = 88, name = "Putney Bridge", zone = "2"),
        StationEntity(id = 89, name = "Parsons Green", zone = "2"),
        StationEntity(id = 90, name = "Fulham Broadway", zone = "2"),
        StationEntity(id = 91, name = "West Brompton", zone = "2"),
        StationEntity(id = 92, name = "Earl's Court", zone = "1/2"),
        StationEntity(id = 93, name = "Kensington Olympia", zone = "2"),
        StationEntity(id = 94, name = "High Street Kensington", zone = "1"),
        StationEntity(id = 95, name = "Gloucester Road", zone = "1"),
        StationEntity(id = 96, name = "South Kensington", zone = "1"),
        StationEntity(id = 97, name = "Sloane Square", zone = "1"),
        StationEntity(id = 98, name = "Victoria", zone = "1"),
        StationEntity(id = 99, name = "St James's Park", zone = "1"),
        StationEntity(id = 100, name = "Westminster", zone = "1"),
        StationEntity(id = 101, name = "Temple", zone = "1"),
        StationEntity(id = 102, name = "Blackfriars", zone = "1"),
        StationEntity(id = 103, name = "Mansion House", zone = "1"),
        StationEntity(id = 104, name = "Cannon Street", zone = "1"),
        StationEntity(id = 105, name = "Monument", zone = "1"),
        StationEntity(id = 106, name = "Tower Hill", zone = "1"),
        StationEntity(id = 107, name = "Aldgate", zone = "1"),
        StationEntity(id = 108, name = "Aldgate East", zone = "1"),
        StationEntity(id = 109, name = "Whitechapel", zone = "2"),
        StationEntity(id = 110, name = "Stepney Green", zone = "2"),
        StationEntity(id = 111, name = "Bow Road", zone = "2/3"),
        StationEntity(id = 112, name = "Bromley-by-Bow", zone = "2/3"),
        StationEntity(id = 113, name = "West Ham", zone = "3"),
        StationEntity(id = 114, name = "Plaistow", zone = "3"),
        StationEntity(id = 115, name = "Upton Park", zone = "3"),
        StationEntity(id = 116, name = "East Ham", zone = "3/4"),
        StationEntity(id = 117, name = "Barking", zone = "4"),
        StationEntity(id = 118, name = "Upney", zone = "4"),
        StationEntity(id = 119, name = "Becontree", zone = "4"),
        StationEntity(id = 120, name = "Dagenham Heathway", zone = "4"),
        StationEntity(id = 121, name = "Dagenham East", zone = "4"),
        StationEntity(id = 122, name = "Elm Park", zone = "4"),
        StationEntity(id = 123, name = "Hornchurch", zone = "4"),
        StationEntity(id = 124, name = "Upminster Bridge", zone = "6"),
        StationEntity(id = 125, name = "Upminster", zone = "6"),
        StationEntity(id = 126, name = "Bayswater", zone = "1"),
        StationEntity(id = 127, name = "Goldhawk Road", zone = "2"),
        StationEntity(id = 128, name = "King's Cross St. Pancras", zone = "1"),
        StationEntity(id = 129, name = "Farringdon", zone = "1"),
        StationEntity(id = 130, name = "Barbican", zone = "1"),
        StationEntity(id = 131, name = "Moorgate", zone = "1"),
        StationEntity(id = 132, name = "Euston Square", zone = "1"),
        StationEntity(id = 133, name = "Great Portland Street", zone = "1"),

        // Jubilee-only
        StationEntity(id = 134, name = "Stanmore", zone = "5"),
        StationEntity(id = 135, name = "Canons Park", zone = "5"),
        StationEntity(id = 136, name = "Queensbury", zone = "4"),
        StationEntity(id = 137, name = "Kingsbury", zone = "4"),
        StationEntity(id = 138, name = "Wembley Park", zone = "4"),
        StationEntity(id = 139, name = "Neasden", zone = "3"),
        StationEntity(id = 140, name = "Dollis Hill", zone = "3"),
        StationEntity(id = 141, name = "Willesden Green", zone = "2/3"),
        StationEntity(id = 142, name = "Kilburn", zone = "2"),
        StationEntity(id = 143, name = "West Hampstead", zone = "2"),
        StationEntity(id = 144, name = "Finchley Road", zone = "2"),
        StationEntity(id = 145, name = "Swiss Cottage", zone = "2"),
        StationEntity(id = 146, name = "St John's Wood", zone = "2"),
        StationEntity(id = 147, name = "Southwark", zone = "1"),
        StationEntity(id = 148, name = "London Bridge", zone = "1"),
        StationEntity(id = 149, name = "Bermondsey", zone = "2"),
        StationEntity(id = 150, name = "Canada Water", zone = "2"),
        StationEntity(id = 151, name = "Canary Wharf", zone = "2"),
        StationEntity(id = 152, name = "North Greenwich", zone = "3"),
        StationEntity(id = 153, name = "Canning Town", zone = "3"),

        // Shared: Jubilee + others
        StationEntity(id = 154, name = "Green Park", zone = "1"),
        StationEntity(id = 155, name = "Warren Street", zone = "1"),
        StationEntity(id = 156, name = "Euston", zone = "1"),

        // Metropolitan-only
        StationEntity(id = 157, name = "Chorleywood", zone = "A"),
        StationEntity(id = 158, name = "Watford", zone = "A"),
        StationEntity(id = 159, name = "Amersham", zone = "A"),
        StationEntity(id = 160, name = "Chesham", zone = "A"),
        StationEntity(id = 161, name = "Chalfont & Latimer", zone = "A"),
        StationEntity(id = 162, name = "Rickmansworth", zone = "A"),
        StationEntity(id = 163, name = "Moor Park", zone = "A"),
        StationEntity(id = 164, name = "Northwood", zone = "6"),
        StationEntity(id = 165, name = "Northwood Hills", zone = "6"),
        StationEntity(id = 166, name = "Pinner", zone = "5"),
        StationEntity(id = 167, name = "North Harrow", zone = "5"),
        StationEntity(id = 168, name = "Harrow-on-the-Hill", zone = "5"),
        StationEntity(id = 169, name = "West Harrow", zone = "5"),
        StationEntity(id = 170, name = "Rayners Lane", zone = "5"),
        StationEntity(id = 171, name = "Eastcote", zone = "5"),
        StationEntity(id = 172, name = "Ruislip Manor", zone = "6"),
        StationEntity(id = 173, name = "Ruislip", zone = "6"),
        StationEntity(id = 174, name = "Ickenham", zone = "6"),
        StationEntity(id = 175, name = "Hillingdon", zone = "6"),
        StationEntity(id = 176, name = "Uxbridge", zone = "6"),
        StationEntity(id = 177, name = "Preston Road", zone = "4"),
        StationEntity(id = 178, name = "Northwick Park", zone = "4"),

        // Northern-only
        StationEntity(id = 180, name = "Edgware", zone = "5"),
        StationEntity(id = 181, name = "Burnt Oak", zone = "4"),
        StationEntity(id = 182, name = "Colindale", zone = "4"),
        StationEntity(id = 183, name = "Hendon Central", zone = "3"),
        StationEntity(id = 184, name = "Brent Cross", zone = "3"),
        StationEntity(id = 185, name = "Golders Green", zone = "3"),
        StationEntity(id = 186, name = "Hampstead", zone = "2"),
        StationEntity(id = 187, name = "Belsize Park", zone = "2"),
        StationEntity(id = 188, name = "Chalk Farm", zone = "2"),
        StationEntity(id = 189, name = "Camden Town", zone = "2"),
        StationEntity(id = 190, name = "Mornington Crescent", zone = "2"),
        StationEntity(id = 191, name = "Goodge Street", zone = "1"),
        StationEntity(id = 192, name = "Leicester Square", zone = "1"),
        StationEntity(id = 193, name = "Borough", zone = "1"),
        StationEntity(id = 194, name = "Kennington", zone = "1/2"),
        StationEntity(id = 195, name = "Oval", zone = "2"),
        StationEntity(id = 196, name = "Stockwell", zone = "2"),
        StationEntity(id = 197, name = "Clapham North", zone = "2"),
        StationEntity(id = 198, name = "Clapham Common", zone = "2"),
        StationEntity(id = 199, name = "Clapham South", zone = "2"),
        StationEntity(id = 200, name = "Balham", zone = "3"),
        StationEntity(id = 201, name = "Tooting Bec", zone = "3"),
        StationEntity(id = 202, name = "Tooting Broadway", zone = "3"),
        StationEntity(id = 203, name = "Colliers Wood", zone = "3"),
        StationEntity(id = 204, name = "South Wimbledon", zone = "3"),
        StationEntity(id = 205, name = "Morden", zone = "4"),
        StationEntity(id = 206, name = "High Barnet", zone = "5"),
        StationEntity(id = 207, name = "Totteridge & Whetstone", zone = "4"),
        StationEntity(id = 208, name = "Woodside Park", zone = "4"),
        StationEntity(id = 209, name = "West Finchley", zone = "4"),
        StationEntity(id = 210, name = "Finchley Central", zone = "4"),
        StationEntity(id = 211, name = "East Finchley", zone = "3"),
        StationEntity(id = 212, name = "Highgate", zone = "3"),
        StationEntity(id = 213, name = "Archway", zone = "2/3"),
        StationEntity(id = 214, name = "Tufnell Park", zone = "2"),
        StationEntity(id = 215, name = "Kentish Town", zone = "2"),
        StationEntity(id = 216, name = "Angel", zone = "1"),
        StationEntity(id = 217, name = "Old Street", zone = "1"),

        // Piccadilly-only
        StationEntity(id = 219, name = "Cockfosters", zone = "5"),
        StationEntity(id = 220, name = "Oakwood", zone = "4"),
        StationEntity(id = 221, name = "Southgate", zone = "4"),
        StationEntity(id = 222, name = "Arnos Grove", zone = "3/4"),
        StationEntity(id = 223, name = "Bounds Green", zone = "3/4"),
        StationEntity(id = 224, name = "Wood Green", zone = "3"),
        StationEntity(id = 225, name = "Turnpike Lane", zone = "3"),
        StationEntity(id = 226, name = "Manor House", zone = "2/3"),
        StationEntity(id = 227, name = "Arsenal", zone = "2"),
        StationEntity(id = 228, name = "Holloway Road", zone = "2"),
        StationEntity(id = 229, name = "Caledonian Road", zone = "2"),
        StationEntity(id = 230, name = "Russell Square", zone = "1"),
        StationEntity(id = 231, name = "Covent Garden", zone = "1"),
        StationEntity(id = 232, name = "Hyde Park Corner", zone = "1"),
        StationEntity(id = 233, name = "Knightsbridge", zone = "1"),
        StationEntity(id = 234, name = "Barons Court", zone = "2"),
        StationEntity(id = 235, name = "Acton Town", zone = "3"),
        StationEntity(id = 236, name = "Chiswick Park", zone = "3"),
        StationEntity(id = 237, name = "Heathrow Terminal 5", zone = "6"),
        StationEntity(id = 238, name = "Heathrow Terminals 2 & 3", zone = "6"),
        StationEntity(id = 239, name = "Heathrow Terminal 4", zone = "6"),
        StationEntity(id = 240, name = "Hatton Cross", zone = "5/6"),
        StationEntity(id = 241, name = "Hounslow West", zone = "5"),
        StationEntity(id = 242, name = "Hounslow Central", zone = "4"),
        StationEntity(id = 243, name = "Hounslow East", zone = "4"),
        StationEntity(id = 244, name = "Osterley", zone = "4"),
        StationEntity(id = 245, name = "Boston Manor", zone = "4"),
        StationEntity(id = 246, name = "Northfields", zone = "3"),
        StationEntity(id = 247, name = "South Ealing", zone = "3"),
        StationEntity(id = 248, name = "South Harrow", zone = "5"),
        StationEntity(id = 249, name = "Sudbury Hill", zone = "4"),
        StationEntity(id = 250, name = "Sudbury Town", zone = "4"),
        StationEntity(id = 251, name = "Alperton", zone = "4"),
        StationEntity(id = 252, name = "Park Royal", zone = "3"),
        StationEntity(id = 253, name = "North Ealing", zone = "3"),

        // Shared: Piccadilly + others
        StationEntity(id = 254, name = "Finsbury Park", zone = "2"),

        // Victoria-only
        StationEntity(id = 256, name = "Brixton", zone = "2"),
        StationEntity(id = 257, name = "Vauxhall", zone = "1/2"),
        StationEntity(id = 258, name = "Pimlico", zone = "1"),
        StationEntity(id = 259, name = "Highbury & Islington", zone = "2"),
        StationEntity(id = 260, name = "Seven Sisters", zone = "3"),
        StationEntity(id = 261, name = "Tottenham Hale", zone = "3"),
        StationEntity(id = 262, name = "Blackhorse Road", zone = "3"),
        StationEntity(id = 263, name = "Walthamstow Central", zone = "3"),
    )

    val crossRefs = listOf(
        // Bakerloo (line 1)
        StationLineCrossRef(stationId = 1, lineId = 1),
        StationLineCrossRef(stationId = 2, lineId = 1),
        StationLineCrossRef(stationId = 3, lineId = 1),
        StationLineCrossRef(stationId = 4, lineId = 1),
        StationLineCrossRef(stationId = 5, lineId = 1),
        StationLineCrossRef(stationId = 6, lineId = 1),
        StationLineCrossRef(stationId = 7, lineId = 1),
        StationLineCrossRef(stationId = 8, lineId = 1),
        StationLineCrossRef(stationId = 9, lineId = 1),
        StationLineCrossRef(stationId = 10, lineId = 1),
        StationLineCrossRef(stationId = 11, lineId = 1),
        StationLineCrossRef(stationId = 12, lineId = 1),
        StationLineCrossRef(stationId = 13, lineId = 1),
        StationLineCrossRef(stationId = 14, lineId = 1),
        StationLineCrossRef(stationId = 15, lineId = 1),
        StationLineCrossRef(stationId = 16, lineId = 1),
        StationLineCrossRef(stationId = 17, lineId = 1), // Paddington
        StationLineCrossRef(stationId = 18, lineId = 1), // Edgware Road
        StationLineCrossRef(stationId = 19, lineId = 1), // Baker Street
        StationLineCrossRef(stationId = 20, lineId = 1), // Oxford Circus
        StationLineCrossRef(stationId = 21, lineId = 1), // Piccadilly Circus
        StationLineCrossRef(stationId = 22, lineId = 1), // Charing Cross
        StationLineCrossRef(stationId = 23, lineId = 1), // Embankment
        StationLineCrossRef(stationId = 24, lineId = 1), // Waterloo
        StationLineCrossRef(stationId = 25, lineId = 1), // Elephant & Castle

        // Central (line 2)
        StationLineCrossRef(stationId = 26, lineId = 2),
        StationLineCrossRef(stationId = 27, lineId = 2),
        StationLineCrossRef(stationId = 28, lineId = 2),
        StationLineCrossRef(stationId = 29, lineId = 2),
        StationLineCrossRef(stationId = 30, lineId = 2),
        StationLineCrossRef(stationId = 31, lineId = 2),
        StationLineCrossRef(stationId = 32, lineId = 2),
        StationLineCrossRef(stationId = 33, lineId = 2),
        StationLineCrossRef(stationId = 34, lineId = 2),
        StationLineCrossRef(stationId = 35, lineId = 2),
        StationLineCrossRef(stationId = 36, lineId = 2),
        StationLineCrossRef(stationId = 37, lineId = 2),
        StationLineCrossRef(stationId = 38, lineId = 2),
        StationLineCrossRef(stationId = 39, lineId = 2),
        StationLineCrossRef(stationId = 40, lineId = 2),
        StationLineCrossRef(stationId = 41, lineId = 2),
        StationLineCrossRef(stationId = 42, lineId = 2),
        StationLineCrossRef(stationId = 43, lineId = 2),
        StationLineCrossRef(stationId = 44, lineId = 2),
        StationLineCrossRef(stationId = 45, lineId = 2),
        StationLineCrossRef(stationId = 46, lineId = 2),
        StationLineCrossRef(stationId = 47, lineId = 2),
        StationLineCrossRef(stationId = 48, lineId = 2),
        StationLineCrossRef(stationId = 49, lineId = 2),
        StationLineCrossRef(stationId = 50, lineId = 2), // Bond Street
        StationLineCrossRef(stationId = 51, lineId = 2),
        StationLineCrossRef(stationId = 52, lineId = 2),
        StationLineCrossRef(stationId = 53, lineId = 2),
        StationLineCrossRef(stationId = 54, lineId = 2),
        StationLineCrossRef(stationId = 55, lineId = 2),
        StationLineCrossRef(stationId = 56, lineId = 2),
        StationLineCrossRef(stationId = 57, lineId = 2),
        StationLineCrossRef(stationId = 58, lineId = 2),
        StationLineCrossRef(stationId = 59, lineId = 2),
        StationLineCrossRef(stationId = 60, lineId = 2),
        StationLineCrossRef(stationId = 61, lineId = 2),
        StationLineCrossRef(stationId = 62, lineId = 2),
        StationLineCrossRef(stationId = 63, lineId = 2),
        StationLineCrossRef(stationId = 64, lineId = 2),
        StationLineCrossRef(stationId = 65, lineId = 2),
        StationLineCrossRef(stationId = 66, lineId = 2),
        StationLineCrossRef(stationId = 67, lineId = 2),
        StationLineCrossRef(stationId = 68, lineId = 2), // Shepherd's Bush Market
        StationLineCrossRef(stationId = 69, lineId = 2), // Wood Lane
        StationLineCrossRef(stationId = 70, lineId = 2), // Latimer Road
        StationLineCrossRef(stationId = 71, lineId = 2), // Notting Hill Gate
        StationLineCrossRef(stationId = 72, lineId = 2), // Liverpool Street
        StationLineCrossRef(stationId = 73, lineId = 2), // Bank
        StationLineCrossRef(stationId = 74, lineId = 2), // Holborn
        StationLineCrossRef(stationId = 75, lineId = 2), // Stratford
        StationLineCrossRef(stationId = 76, lineId = 2), // Mile End

        // Circle (line 3)
        StationLineCrossRef(stationId = 17, lineId = 3), // Paddington
        StationLineCrossRef(stationId = 18, lineId = 3), // Edgware Road
        StationLineCrossRef(stationId = 19, lineId = 3), // Baker Street
        StationLineCrossRef(stationId = 68, lineId = 3), // Shepherd's Bush Market
        StationLineCrossRef(stationId = 69, lineId = 3), // Wood Lane
        StationLineCrossRef(stationId = 70, lineId = 3), // Latimer Road
        StationLineCrossRef(stationId = 71, lineId = 3), // Notting Hill Gate
        StationLineCrossRef(stationId = 72, lineId = 3), // Liverpool Street
        StationLineCrossRef(stationId = 74, lineId = 3), // Holborn
        StationLineCrossRef(stationId = 76, lineId = 3), // Mile End
        StationLineCrossRef(stationId = 77, lineId = 3), // Hammersmith
        StationLineCrossRef(stationId = 94, lineId = 3), // High Street Kensington
        StationLineCrossRef(stationId = 95, lineId = 3), // Gloucester Road
        StationLineCrossRef(stationId = 96, lineId = 3), // South Kensington
        StationLineCrossRef(stationId = 97, lineId = 3), // Sloane Square
        StationLineCrossRef(stationId = 98, lineId = 3), // Victoria
        StationLineCrossRef(stationId = 99, lineId = 3), // St James's Park
        StationLineCrossRef(stationId = 100, lineId = 3), // Westminster
        StationLineCrossRef(stationId = 23, lineId = 3), // Embankment
        StationLineCrossRef(stationId = 101, lineId = 3), // Temple
        StationLineCrossRef(stationId = 102, lineId = 3), // Blackfriars
        StationLineCrossRef(stationId = 103, lineId = 3), // Mansion House
        StationLineCrossRef(stationId = 104, lineId = 3), // Cannon Street
        StationLineCrossRef(stationId = 105, lineId = 3), // Monument
        StationLineCrossRef(stationId = 106, lineId = 3), // Tower Hill
        StationLineCrossRef(stationId = 107, lineId = 3), // Aldgate
        StationLineCrossRef(stationId = 128, lineId = 3), // King's Cross
        StationLineCrossRef(stationId = 129, lineId = 3), // Farringdon
        StationLineCrossRef(stationId = 130, lineId = 3), // Barbican
        StationLineCrossRef(stationId = 131, lineId = 3), // Moorgate
        StationLineCrossRef(stationId = 132, lineId = 3), // Euston Square
        StationLineCrossRef(stationId = 133, lineId = 3), // Great Portland Street

        // District (line 4)
        StationLineCrossRef(stationId = 17, lineId = 4), // Paddington
        StationLineCrossRef(stationId = 71, lineId = 4), // Notting Hill Gate
        StationLineCrossRef(stationId = 77, lineId = 4), // Hammersmith
        StationLineCrossRef(stationId = 78, lineId = 4),
        StationLineCrossRef(stationId = 79, lineId = 4),
        StationLineCrossRef(stationId = 80, lineId = 4),
        StationLineCrossRef(stationId = 81, lineId = 4), // Gunnersbury
        StationLineCrossRef(stationId = 82, lineId = 4), // Kew Gardens
        StationLineCrossRef(stationId = 83, lineId = 4), // Richmond
        StationLineCrossRef(stationId = 84, lineId = 4), // Wimbledon
        StationLineCrossRef(stationId = 85, lineId = 4),
        StationLineCrossRef(stationId = 86, lineId = 4),
        StationLineCrossRef(stationId = 87, lineId = 4),
        StationLineCrossRef(stationId = 88, lineId = 4),
        StationLineCrossRef(stationId = 89, lineId = 4),
        StationLineCrossRef(stationId = 90, lineId = 4),
        StationLineCrossRef(stationId = 91, lineId = 4),
        StationLineCrossRef(stationId = 92, lineId = 4), // Earl's Court
        StationLineCrossRef(stationId = 93, lineId = 4), // Kensington Olympia
        StationLineCrossRef(stationId = 94, lineId = 4), // High Street Kensington
        StationLineCrossRef(stationId = 95, lineId = 4), // Gloucester Road
        StationLineCrossRef(stationId = 96, lineId = 4), // South Kensington
        StationLineCrossRef(stationId = 97, lineId = 4), // Sloane Square
        StationLineCrossRef(stationId = 98, lineId = 4), // Victoria
        StationLineCrossRef(stationId = 99, lineId = 4), // St James's Park
        StationLineCrossRef(stationId = 100, lineId = 4), // Westminster
        StationLineCrossRef(stationId = 23, lineId = 4), // Embankment
        StationLineCrossRef(stationId = 102, lineId = 4), // Blackfriars
        StationLineCrossRef(stationId = 103, lineId = 4), // Mansion House
        StationLineCrossRef(stationId = 104, lineId = 4), // Cannon Street
        StationLineCrossRef(stationId = 105, lineId = 4), // Monument
        StationLineCrossRef(stationId = 106, lineId = 4), // Tower Hill
        StationLineCrossRef(stationId = 108, lineId = 4), // Aldgate East
        StationLineCrossRef(stationId = 109, lineId = 4), // Whitechapel
        StationLineCrossRef(stationId = 110, lineId = 4), // Stepney Green
        StationLineCrossRef(stationId = 76, lineId = 4), // Mile End
        StationLineCrossRef(stationId = 111, lineId = 4), // Bow Road
        StationLineCrossRef(stationId = 112, lineId = 4), // Bromley-by-Bow
        StationLineCrossRef(stationId = 113, lineId = 4), // West Ham
        StationLineCrossRef(stationId = 114, lineId = 4),
        StationLineCrossRef(stationId = 115, lineId = 4),
        StationLineCrossRef(stationId = 116, lineId = 4),
        StationLineCrossRef(stationId = 117, lineId = 4), // Barking
        StationLineCrossRef(stationId = 118, lineId = 4),
        StationLineCrossRef(stationId = 119, lineId = 4),
        StationLineCrossRef(stationId = 120, lineId = 4),
        StationLineCrossRef(stationId = 121, lineId = 4),
        StationLineCrossRef(stationId = 122, lineId = 4),
        StationLineCrossRef(stationId = 123, lineId = 4),
        StationLineCrossRef(stationId = 124, lineId = 4),
        StationLineCrossRef(stationId = 125, lineId = 4), // Upminster
        StationLineCrossRef(stationId = 235, lineId = 4), // Acton Town
        StationLineCrossRef(stationId = 236, lineId = 4), // Chiswick Park

        // Hammersmith & City (line 5)
        StationLineCrossRef(stationId = 17, lineId = 5), // Paddington
        StationLineCrossRef(stationId = 18, lineId = 5), // Edgware Road
        StationLineCrossRef(stationId = 19, lineId = 5), // Baker Street
        StationLineCrossRef(stationId = 68, lineId = 5), // Shepherd's Bush Market
        StationLineCrossRef(stationId = 69, lineId = 5), // Wood Lane
        StationLineCrossRef(stationId = 70, lineId = 5), // Latimer Road
        StationLineCrossRef(stationId = 126, lineId = 5), // Bayswater? No — Ladbroke Grove
        StationLineCrossRef(stationId = 127, lineId = 5), // Goldhawk Road
        StationLineCrossRef(stationId = 77, lineId = 5), // Hammersmith
        StationLineCrossRef(stationId = 108, lineId = 5), // Aldgate East
        StationLineCrossRef(stationId = 109, lineId = 5), // Whitechapel
        StationLineCrossRef(stationId = 110, lineId = 5), // Stepney Green
        StationLineCrossRef(stationId = 76, lineId = 5), // Mile End
        StationLineCrossRef(stationId = 111, lineId = 5), // Bow Road
        StationLineCrossRef(stationId = 112, lineId = 5), // Bromley-by-Bow
        StationLineCrossRef(stationId = 113, lineId = 5), // West Ham
        StationLineCrossRef(stationId = 117, lineId = 5), // Barking
        StationLineCrossRef(stationId = 128, lineId = 5), // King's Cross
        StationLineCrossRef(stationId = 129, lineId = 5), // Farringdon
        StationLineCrossRef(stationId = 130, lineId = 5), // Barbican
        StationLineCrossRef(stationId = 131, lineId = 5), // Moorgate
        StationLineCrossRef(stationId = 72, lineId = 5), // Liverpool Street
        StationLineCrossRef(stationId = 132, lineId = 5), // Euston Square
        StationLineCrossRef(stationId = 133, lineId = 5), // Great Portland Street

        // Jubilee (line 6)
        StationLineCrossRef(stationId = 19, lineId = 6), // Baker Street
        StationLineCrossRef(stationId = 50, lineId = 6), // Bond Street
        StationLineCrossRef(stationId = 154, lineId = 6), // Green Park
        StationLineCrossRef(stationId = 100, lineId = 6), // Westminster
        StationLineCrossRef(stationId = 24, lineId = 6), // Waterloo
        StationLineCrossRef(stationId = 147, lineId = 6),
        StationLineCrossRef(stationId = 148, lineId = 6), // London Bridge
        StationLineCrossRef(stationId = 149, lineId = 6),
        StationLineCrossRef(stationId = 150, lineId = 6),
        StationLineCrossRef(stationId = 151, lineId = 6),
        StationLineCrossRef(stationId = 152, lineId = 6),
        StationLineCrossRef(stationId = 153, lineId = 6),
        StationLineCrossRef(stationId = 113, lineId = 6), // West Ham
        StationLineCrossRef(stationId = 75, lineId = 6), // Stratford
        StationLineCrossRef(stationId = 134, lineId = 6),
        StationLineCrossRef(stationId = 135, lineId = 6),
        StationLineCrossRef(stationId = 136, lineId = 6),
        StationLineCrossRef(stationId = 137, lineId = 6),
        StationLineCrossRef(stationId = 138, lineId = 6),
        StationLineCrossRef(stationId = 139, lineId = 6),
        StationLineCrossRef(stationId = 140, lineId = 6),
        StationLineCrossRef(stationId = 141, lineId = 6),
        StationLineCrossRef(stationId = 142, lineId = 6),
        StationLineCrossRef(stationId = 143, lineId = 6),
        StationLineCrossRef(stationId = 144, lineId = 6),
        StationLineCrossRef(stationId = 145, lineId = 6),
        StationLineCrossRef(stationId = 146, lineId = 6),

        // Metropolitan (line 7)
        StationLineCrossRef(stationId = 19, lineId = 7), // Baker Street
        StationLineCrossRef(stationId = 128, lineId = 7), // King's Cross
        StationLineCrossRef(stationId = 129, lineId = 7), // Farringdon
        StationLineCrossRef(stationId = 130, lineId = 7), // Barbican
        StationLineCrossRef(stationId = 131, lineId = 7), // Moorgate
        StationLineCrossRef(stationId = 72, lineId = 7), // Liverpool Street
        StationLineCrossRef(stationId = 107, lineId = 7), // Aldgate
        StationLineCrossRef(stationId = 132, lineId = 7), // Euston Square
        StationLineCrossRef(stationId = 133, lineId = 7), // Great Portland Street
        StationLineCrossRef(stationId = 17, lineId = 7), // Paddington
        StationLineCrossRef(stationId = 157, lineId = 7),
        StationLineCrossRef(stationId = 158, lineId = 7), // Watford
        StationLineCrossRef(stationId = 159, lineId = 7),
        StationLineCrossRef(stationId = 160, lineId = 7),
        StationLineCrossRef(stationId = 161, lineId = 7),
        StationLineCrossRef(stationId = 162, lineId = 7),
        StationLineCrossRef(stationId = 163, lineId = 7),
        StationLineCrossRef(stationId = 164, lineId = 7),
        StationLineCrossRef(stationId = 165, lineId = 7),
        StationLineCrossRef(stationId = 166, lineId = 7),
        StationLineCrossRef(stationId = 167, lineId = 7),
        StationLineCrossRef(stationId = 168, lineId = 7),
        StationLineCrossRef(stationId = 169, lineId = 7),
        StationLineCrossRef(stationId = 170, lineId = 7),
        StationLineCrossRef(stationId = 171, lineId = 7),
        StationLineCrossRef(stationId = 172, lineId = 7),
        StationLineCrossRef(stationId = 173, lineId = 7),
        StationLineCrossRef(stationId = 174, lineId = 7),
        StationLineCrossRef(stationId = 175, lineId = 7),
        StationLineCrossRef(stationId = 176, lineId = 7),
        StationLineCrossRef(stationId = 177, lineId = 7),
        StationLineCrossRef(stationId = 178, lineId = 7),
        StationLineCrossRef(stationId = 1, lineId = 7), // Harrow & Wealdstone
        StationLineCrossRef(stationId = 2, lineId = 7), // Kenton

        // Northern (line 8)
        StationLineCrossRef(stationId = 180, lineId = 8),
        StationLineCrossRef(stationId = 181, lineId = 8),
        StationLineCrossRef(stationId = 182, lineId = 8),
        StationLineCrossRef(stationId = 183, lineId = 8),
        StationLineCrossRef(stationId = 184, lineId = 8),
        StationLineCrossRef(stationId = 185, lineId = 8),
        StationLineCrossRef(stationId = 186, lineId = 8),
        StationLineCrossRef(stationId = 187, lineId = 8),
        StationLineCrossRef(stationId = 188, lineId = 8),
        StationLineCrossRef(stationId = 189, lineId = 8),
        StationLineCrossRef(stationId = 190, lineId = 8),
        StationLineCrossRef(stationId = 156, lineId = 8), // Euston
        StationLineCrossRef(stationId = 155, lineId = 8), // Warren Street
        StationLineCrossRef(stationId = 191, lineId = 8),
        StationLineCrossRef(stationId = 49, lineId = 8), // Tottenham Court Road
        StationLineCrossRef(stationId = 192, lineId = 8), // Leicester Square
        StationLineCrossRef(stationId = 22, lineId = 8), // Charing Cross
        StationLineCrossRef(stationId = 23, lineId = 8), // Embankment
        StationLineCrossRef(stationId = 24, lineId = 8), // Waterloo
        StationLineCrossRef(stationId = 148, lineId = 8), // London Bridge
        StationLineCrossRef(stationId = 193, lineId = 8),
        StationLineCrossRef(stationId = 25, lineId = 8), // Elephant & Castle
        StationLineCrossRef(stationId = 194, lineId = 8),
        StationLineCrossRef(stationId = 195, lineId = 8),
        StationLineCrossRef(stationId = 196, lineId = 8), // Stockwell
        StationLineCrossRef(stationId = 197, lineId = 8),
        StationLineCrossRef(stationId = 198, lineId = 8),
        StationLineCrossRef(stationId = 199, lineId = 8),
        StationLineCrossRef(stationId = 200, lineId = 8),
        StationLineCrossRef(stationId = 201, lineId = 8),
        StationLineCrossRef(stationId = 202, lineId = 8),
        StationLineCrossRef(stationId = 203, lineId = 8),
        StationLineCrossRef(stationId = 204, lineId = 8),
        StationLineCrossRef(stationId = 205, lineId = 8),
        StationLineCrossRef(stationId = 206, lineId = 8),
        StationLineCrossRef(stationId = 207, lineId = 8),
        StationLineCrossRef(stationId = 208, lineId = 8),
        StationLineCrossRef(stationId = 209, lineId = 8),
        StationLineCrossRef(stationId = 210, lineId = 8),
        StationLineCrossRef(stationId = 211, lineId = 8),
        StationLineCrossRef(stationId = 212, lineId = 8),
        StationLineCrossRef(stationId = 213, lineId = 8),
        StationLineCrossRef(stationId = 214, lineId = 8),
        StationLineCrossRef(stationId = 215, lineId = 8),
        StationLineCrossRef(stationId = 216, lineId = 8),
        StationLineCrossRef(stationId = 217, lineId = 8),
        StationLineCrossRef(stationId = 131, lineId = 8), // Moorgate
        StationLineCrossRef(stationId = 73, lineId = 8), // Bank

        // Piccadilly (line 9)
        StationLineCrossRef(stationId = 219, lineId = 9),
        StationLineCrossRef(stationId = 220, lineId = 9),
        StationLineCrossRef(stationId = 221, lineId = 9),
        StationLineCrossRef(stationId = 222, lineId = 9),
        StationLineCrossRef(stationId = 223, lineId = 9),
        StationLineCrossRef(stationId = 224, lineId = 9),
        StationLineCrossRef(stationId = 225, lineId = 9),
        StationLineCrossRef(stationId = 226, lineId = 9),
        StationLineCrossRef(stationId = 254, lineId = 9), // Finsbury Park
        StationLineCrossRef(stationId = 227, lineId = 9),
        StationLineCrossRef(stationId = 228, lineId = 9),
        StationLineCrossRef(stationId = 229, lineId = 9),
        StationLineCrossRef(stationId = 128, lineId = 9), // King's Cross
        StationLineCrossRef(stationId = 230, lineId = 9),
        StationLineCrossRef(stationId = 74, lineId = 9), // Holborn
        StationLineCrossRef(stationId = 231, lineId = 9),
        StationLineCrossRef(stationId = 192, lineId = 9), // Leicester Square
        StationLineCrossRef(stationId = 21, lineId = 9), // Piccadilly Circus
        StationLineCrossRef(stationId = 154, lineId = 9), // Green Park
        StationLineCrossRef(stationId = 232, lineId = 9),
        StationLineCrossRef(stationId = 233, lineId = 9),
        StationLineCrossRef(stationId = 96, lineId = 9), // South Kensington
        StationLineCrossRef(stationId = 95, lineId = 9), // Gloucester Road
        StationLineCrossRef(stationId = 92, lineId = 9), // Earl's Court
        StationLineCrossRef(stationId = 234, lineId = 9),
        StationLineCrossRef(stationId = 77, lineId = 9),  // Hammersmith
        StationLineCrossRef(stationId = 235, lineId = 9), // Acton Town
        StationLineCrossRef(stationId = 236, lineId = 9), // Chiswick Park
        StationLineCrossRef(stationId = 81, lineId = 9), // Gunnersbury
        StationLineCrossRef(stationId = 82, lineId = 9), // Kew Gardens
        StationLineCrossRef(stationId = 83, lineId = 9), // Richmond
        StationLineCrossRef(stationId = 237, lineId = 9),
        StationLineCrossRef(stationId = 238, lineId = 9),
        StationLineCrossRef(stationId = 239, lineId = 9),
        StationLineCrossRef(stationId = 240, lineId = 9),
        StationLineCrossRef(stationId = 241, lineId = 9),
        StationLineCrossRef(stationId = 242, lineId = 9),
        StationLineCrossRef(stationId = 243, lineId = 9),
        StationLineCrossRef(stationId = 244, lineId = 9),
        StationLineCrossRef(stationId = 245, lineId = 9),
        StationLineCrossRef(stationId = 246, lineId = 9),
        StationLineCrossRef(stationId = 247, lineId = 9),
        StationLineCrossRef(stationId = 64, lineId = 9), // Northolt
        StationLineCrossRef(stationId = 248, lineId = 9),
        StationLineCrossRef(stationId = 249, lineId = 9),
        StationLineCrossRef(stationId = 250, lineId = 9),
        StationLineCrossRef(stationId = 251, lineId = 9),
        StationLineCrossRef(stationId = 252, lineId = 9),
        StationLineCrossRef(stationId = 253, lineId = 9),

        // Victoria (line 10)
        StationLineCrossRef(stationId = 256, lineId = 10),
        StationLineCrossRef(stationId = 196, lineId = 10), // Stockwell
        StationLineCrossRef(stationId = 257, lineId = 10),
        StationLineCrossRef(stationId = 258, lineId = 10),
        StationLineCrossRef(stationId = 98, lineId = 10), // Victoria
        StationLineCrossRef(stationId = 154, lineId = 10), // Green Park
        StationLineCrossRef(stationId = 20, lineId = 10), // Oxford Circus
        StationLineCrossRef(stationId = 155, lineId = 10), // Warren Street
        StationLineCrossRef(stationId = 156, lineId = 10), // Euston
        StationLineCrossRef(stationId = 128, lineId = 10), // King's Cross
        StationLineCrossRef(stationId = 259, lineId = 10),
        StationLineCrossRef(stationId = 254, lineId = 10), // Finsbury Park
        StationLineCrossRef(stationId = 260, lineId = 10),
        StationLineCrossRef(stationId = 261, lineId = 10),
        StationLineCrossRef(stationId = 262, lineId = 10),
        StationLineCrossRef(stationId = 263, lineId = 10),

        // Waterloo & City (line 11)
        StationLineCrossRef(stationId = 24, lineId = 11), // Waterloo
        StationLineCrossRef(stationId = 73, lineId = 11), // Bank
    )
}