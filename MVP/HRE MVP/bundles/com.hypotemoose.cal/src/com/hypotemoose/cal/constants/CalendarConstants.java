/*****************************************************************************
 * Copyright 2016 Chris Engelsma
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *****************************************************************************/
package com.hypotemoose.cal.constants;

/**
 * @author Chris Engelsma
 * @since 2016.03.14
 */
public final class CalendarConstants {

	public static final class CopticCalendarConstants {
		public static final String[] weekDayNames = { "Raviara", "Somavara",
				"Mangalva", "Budhavara", "Guruvara", "Skuravara", "Sanivara" };

		public static final String[] monthNames = { "Thout", "Paopi", "Hathor",
				"Koiak", "Tobi", "Meshir", "Paremhat", "Paremoude", "Pashons",
				"Paoni", "Epip", "Mesori", "Pi Kogi Enavot" };
	}

	public static final class FrenchRepublicanCalendarConstants {

		public static final String[] monthNames = { "Vendémiaire", "Brumaire",
				"Frimaire", "Nivôse", "Pluviôse", "Ventôse", "Germinal",
				"Floréal", "Prairial", "Messidor", "Thermidor", "Fructidor",
				"Sans-culottides" };

		public static final String[] weekDayNames = { "Primidi", "Duodi",
				"Tridi", "Quartidi", "Quintidi", "Sextidi", "Septidi", "Octidi",
				"Nonidi", "Décadi" };

		public static final String[][] dayNames = {
				// Vendémiaire
				{ "Raisin", "Safran", "Châtaigne", "Colchique", "Cheval",
						"Balsamine", "Carotte", "Amaranthe", "Panais", "Cuve",
						"Pomme de terre", "Immortelle", "Potiron", "Réséda",
						"Âne", "Belle de nuit", "Citrouille", "Sarrasin",
						"Tournesol", "Pressoir", "Chanvre", "Pêche", "Navet",
						"Amaryllis", "Bœuf", "Aubergine", "Piment", "Tomate",
						"Orge", "Tonneau" },
				// Brumaire
				{ "Pomme", "Céleri", "Poire", "Betterave", "Oie",
						"Héliotrope", "Figue", "Scorsonère", "Alisier",
						"Charrue", "Salsifis", "Mâcre", "Topinambour",
						"Endive", "Dindon", "Chervis", "Cresson", "Dentelaire",
						"Grenade", "Herse", "Bacchante", "Azerole", "Garance",
						"Orange", "Faisan", "Pistache", "Macjonc", "Coing",
						"Cormier", "Rouleau" },
				// Frimaire
				{ "Raiponce", "Turneps", "Chicorée", "Nèfle", "Cochon",
						"Mâche", "Chou-fleur", "Miel", "Genièvre", "Pioche",
						"Cire", "Raifort", "Cèdre", "Sapin", "Chevreuil",
						"Ajonc", "Cyprès", "Lierre", "Sabine", "Hoyau",
						"Érable à sucre", "Bruyère", "Roseau", "Oseille",
						"Grillon", "Pignon", "Liège", "Truffe", "Olive",
						"Pelle" },
				// Nivôse
				{ "Tourbe", "Houille", "Bitume", "Soufre", "Chien", "Lave",
						"Terre végétale", "Fumier", "Salpêtre", "Fléau",
						"Granit", "Argile", "Ardoise", "Grès", "Lapin",
						"Silex", "Marne", "Pierre à chaux", "Marbre", "Van",
						"Pierre à plâtre", "Sel", "Fer", "Cuivre", "Chat",
						"Étain", "Plomb", "Zinc", "Mercure", "Crible" },
				// Pluviôse
				{ "Lauréole", "Mousse", "Fragon", "Perce-neige", "Taureau",
						"Laurier-thym", "Amadouvier", "Mézéréon", "Peuplier",
						"Coignée", "Ellébore", "Brocoli", "Laurier",
						"Avelinier", "Vache", "Buis", "Lichen", "If",
						"Pulmonaire", "Serpette", "Thlaspi", "Thimelé",
						"Chiendent", "Trainasse", "Lièvre", "Guède",
						"Noisetier", "Cyclamen", "Chélidoine", "Traîneau" },
				// Ventôse
				{ "Tussilage", "Cornouiller", "Violier", "Troène", "Bouc",
						"Asaret", "Alaterne", "Violette", "Marceau", "Bêche",
						"Narcisse", "Orme", "Fumeterre", "Vélar", "Chêvre",
						"Épinard", "Doronic", "Mouron", "Cerfeuil", "Cordeau",
						"Mandragore", "Persil", "Cochléaria", "Pâquerette",
						"Thon", "Pissenlit", "Sylvie", "Capillaire", "Frêne",
						"Plantoir" },
				// Germinal
				{ "Primevère", "Platane", "Asperge", "Tulipe", "Poule",
						"Bette", "Bouleau", "Jonquille", "Aulne", "Couvoir",
						"Pervenche", "Charme", "Morille", "Hêtre", "Abeille",
						"Laitue", "Mélèze", "Ciguë", "Radis", "Ruche",
						"Gainier", "Romaine", "Marronnier", "Roquette",
						"Pigeon", "Lilas", "Anémone", "Pensée", "Myrtille",
						"Greffoir" },
				// Floréal
				{ "Rose", "Chêne", "Fougère", "Aubépine", "Rossignol",
						"Ancolie", "Muguet", "Champignon", "Hyacinthe",
						"Râteau", "Rhubarbe", "Sainfoin", "Bâton d'or",
						"Charmerisier", "Ver à soie", "Consoude",
						"Pimprenelle", "Corbeille d'or", "Arroche", "Sarcloir",
						"Statice", "Fritillaire", "Bourrache", "Valériane",
						"Carpe", "Fusain", "Civette", "Buglosse", "Sénevé",
						"Houlette" },
				// Prairial
				{ "Luzerne", "Hémérocalle", "Trèfle", "Angélique", "Canard",
						"Mélisse", "Fromental", "Martagon", "Serpolet", "Faux",
						"Fraise", "Bétoine", "Pois", "Acacia", "Caille",
						"Œillet", "Sureau", "Pavot", "Tilleul", "Fourche",
						"Barbeau", "Camomille", "Chèvrefeuille", "Caille-lait",
						"Tanche", "Jasmin", "Verveine", "Thym", "Pivoine",
						"Chariot" },
				// Messidor
				{ "Seigle", "Avoine", "Oignon", "Véronique", "Mulet",
						"Romarin", "Concombre", "Échalote", "Absinthe",
						"Faucille", "Coriandre", "Artichaut", "Girofle",
						"Lavande", "Chamois", "Tabac", "Groseille", "Gesse",
						"Cerise", "Parc", "Menthe", "Cumin", "Haricot",
						"Haricot", "Orcanète", "Pintade", "Sauge", "Ail",
						"Vesce", "Blé", "Chalémie" },
				// Thermidor
				{ "Épeautre", "Bouillon blanc", "Melon", "Ivraie", "Bélier",
						"Prêle", "Armoise", "Carthame", "Mûre", "Arrosoir",
						"Panic", "Salicorne", "Abricot", "Basilic", "Brebis",
						"Guimauve", "Lin", "Amande", "Gentiane", "Écluse",
						"Carline", "Câprier", "Lentille", "Aunée", "Loutre",
						"Myrte", "Colza", "Lupin", "Coton", "Moulin" },
				// Fructidor
				{ "Prune", "Millet", "Lycoperdon", "Escourgeon", "Saumon",
						"Tubéreuse", "Sucrion", "Apocyn", "Réglisse",
						"Échelle", "Pastèque", "Fenouil", "Épine vinette",
						"Noix", "Truite", "Citron", "Cardère", "Nerprun",
						"Tagette", "Hotte", "Églantier", "Noisette", "Houblon",
						"Sorgho", "Écrevisse", "Bigarade", "Verge d'or",
						"Maïs", "Marron", "Panier" },
				// Sans-culottides
				{ "La Fête de la Vertu", "La Fête du Génie",
						"La Fête di Travail", "La Fête de l'Opinion",
						"La Fête des Récompenses",
						"La Fête de la Révolution" } };
	}

	public static final class GregorianCalendarConstants {

		public static final String[] weekDayNames = { "Sunday", "Monday",
				"Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

		public static final String[] monthNames = { "January", "February",
				"March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		public static final String[] _eras = { "BC", "BCE", "AD", "CE" };
	}

	public static final class HebrewCalendarConstants {
		public static final String[] weekDayNames = { "Yom Rishon", "Yom Sheni",
				"Yom Shlishi", "Yom Revi'i", "Yom Chamishi", "Yom Shishi",
				"Yom Shabbat" };

		public static final String[] monthNames = { "Nisan", "Iyar", "Sivan",
				"Tammuz", "Av", "Elul", "Tishrei", "Marcheshvan", "Kislev",
				"Tevet", "Shevat", "Adar", "Veadar" };
	}

	public static final class IndianCivilCalendarConstants {
		public static final String[] weekDayNames = { "Raviara", "Somavara",
				"Mangalva", "Budhavara", "Guruvara", "Skuravara", "Sanivara" };

		public static final String[] monthNames = { "Chaitra", "Vaisakha",
				"Jyeshtha", "Ashadha", "Shravana", "Bhaadra", "Ashwin",
				"Kartika", "Agrahayana", "Pausha", "Magha", "Phalguna" };
	}

	public static final class IslamicCalendarConstants {
		public static final String[] weekDayNames = { "Al-ahad", "Al-ithnayn",
				"Ath-thulatha'", "Al-arba'a", "Al-khamis", "Al-jumu'ah",
				"As-sabt" };

		public static final String[] monthNames = { "Muharram", "Safar",
				"Rabi' al-Awwal", "Rabi' ath-Thani", "Jumada al-Ula",
				"Jumada ath-Thaniyah", "Rajab", "Sha'ban", "Ramadan", "Shawwal",
				"Dhu al-Qa'dah", "Dhu al-Hijjah" };
	}

	public static final class JulianCalendarConstants {

		public static final String[] weekDayNames = { "Sunday", "Monday",
				"Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		public static final String[] monthNames = { "January", "Ianuarius",
				"February", "Februarius", "March", "Martius", "April",
				"Aprilis", "May", "Maius", "June", "Iunius", "July", "Iulius",
				"August", "Augustus", "September", "September", "October",
				"October", "November", "November", "December", "December" };
	}

	public static final class MayaCalendarConstants {
	}

	public static final class PersianCalendarConstants {
		public static final String[] weekDayNames = { "Yekshanbeh", "Doshanbeh",
				"Seshhanbeh", "Chaharshanbeh", "Panjshanbeh", "Jomeh",
				"Shanbeh" };

		public static final String[] monthNames = { "Farvardin", "Ordibehesht",
				"Khordad", "Tir", "Mordad", "Shahrivar", "Mehr", "Aban", "Azar",
				"Dey", "Bahman", "Esfand" };
	}
}
