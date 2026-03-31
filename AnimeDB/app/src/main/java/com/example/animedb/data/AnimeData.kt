package com.example.animedb.data

data class Anime(
    val id:Int=0,
    val titulo:String="",
    val creador:String="",
    val anyo:Int=1900
)

val animes:List<Anime> = listOf(
    Anime(1,"Fullmetal Alchemist: Brotherhood","Hiromu Arakawa",2009),
    Anime(2,"Steins;Gate","Chiyomaru Shikura",2011),
    Anime(3,"Hunter x Hunter","Yoshihiro Togashi",2011),
    Anime(4,"Gintama","Hideaki Sorachi",2005),
    Anime(5,"Attack on Titan","Hajime Isayama",2013),
    Anime(6,"Death Note","Tsugumi Ohba",2006),
    Anime(7,"Cowboy Bebop","Shinichiro Watanabe",1998),
    Anime(8,"Code Geass","Ichiro Okouchi",2006),
    Anime(9,"One Piece","Eiichiro Oda",1999),
    Anime(10,"Neon Genesis Evangelion","Hideaki Anno",1995),
    Anime(11,"Demon Slayer","Koyoharu Gotouge",2019),
    Anime(12,"Your Lie in April","Naoshi Arakawa",2014),
    Anime(13,"Monster","Naoki Urasawa",2004),
    Anime(14,"Clannad","Key",2007),
    Anime(15,"Made in Abyss","Akihito Tsukushi",2017),
    Anime(16,"Vinland Saga","Makoto Yukimura",2019),
    Anime(17,"Mob Psycho 100","ONE",2016),
    Anime(18,"Frieren: Beyond Journey's End","Kanehito Yamada",2023),
    Anime(19,"Jujutsu Kaisen","Gege Akutami",2020),
    Anime(20,"Chainsaw Man","Tatsuki Fujimoto",2022)
    )
