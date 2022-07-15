package com.example.quizapp

object Constants {
    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTIONS:String = "total_question"
    const val CORRECT_ANSWERS:String = "correct_answers"

    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        questionList.add(
            Question(
                1, "Who is Tony Stark’s father?",
                R.drawable.tony_stark,
                "Anthony Stark",
                "Howard Stark",
                "Happy Stark",
                "Edward Stark",
                2
            )
        )

        questionList.add(
            Question(
                2, "What does S.H.I.E.L.D. stand for?",
                R.drawable.shield_logo,
                "Strategic Homeland Intervention, Enforcement and Logistics Division.",
                "Strategic Homeland Intention, Enforcement and Logistics Division.",
                "Strategic Homeland Intervention, Enforcement and Loveable Division.",
                "Strategic Homeland Intervention, Enforcement and Logistics Discussion.",
                1
            )
        )

        questionList.add(
            Question(
                3, "What type of doctor is Doctor Strange?",
                R.drawable.doctor_strange,
                "A Cardiologist",
                "A Dentist",
                "A neurosurgeon",
                "A Gynaecologist",
                3
            )
        )

        questionList.add(
            Question(
                4, "Captain America’s shield and Bucky’s arm are made of what?",
                R.drawable.america_and_bucky,
                "A Titanium",
                "A Vibranium",
                "A Tungsten",
                "A Chromium",
                2
            )
        )

        questionList.add(
            Question(
                5, "Who was able to pick up Thor’s hammer in Endgame?",
                R.drawable.mjolnir,
                "Captain America",
                "Hulk",
                "Ironman",
                "Spiderman",
                1
            )
        )

        questionList.add(
            Question(
                6, "In which movie did Spider-Man make his first appearance in the MCU?",
                R.drawable.spiderman,
                "Spider-Man: Far From Home",
                "Avengers: Infinity War",
                "Spider-Man: Homecoming",
                "Captain America: Civil War.",
                4
            )
        )

        questionList.add(
            Question(
                7, "On what planet was the Soul Stone in Infinity War?",
                R.drawable.soul_stone,
                "Vormir",
                "Titan",
                "Nidavellir",
                "Earth",
                1
            )
        )

        questionList.add(
            Question(
                8, "Who rescued Tony Stark and Nebula from space?",
                R.drawable.tony_stark_nebula,
                "Thor",
                "Captain Marvel",
                "Star Lord",
                "Gamora",
                2
            )
        )

        questionList.add(
            Question(
                9, "Hawkeye has how many children?",
                R.drawable.hawkeye,
                "1",
                "2",
                "3",
                "4",
                3
            )
        )

        questionList.add(
            Question(
                10, "Nick Fury wears an eye patch over which eye? ",
                R.drawable.nick_fury,
                "None",
                "Both",
                "Right",
                "Left",
                4
            )
        )

        questionList.add(
            Question(
                11, "Thor’s Mjolnir is made from the metal of a dying ___?",
                R.drawable.mjolnir,
                "Star",
                "Groot",
                "Meteor",
                "Alien",
                1
            )
        )

        questionList.add(
            Question(
                12, "Pym Particles were created by who?",
                R.drawable.pym_particles,
                "Hope Pym",
                "Janet Pym",
                "Hank Pym",
                "Scott Lang",
                3
            )
        )

        questionList.add(
            Question(
                13, "Ant Man was trapped in the Quantum Realm for how long?",
                R.drawable.ant_man,
                "5",
                "4",
                "3",
                "2",
                1
            )
        )

        questionList.add(
            Question(
                14, "What are the names of Wanda’s twins?",
                R.drawable.wanda,
                "Alice And Bob",
                "Billy And Tommy",
                "Alice And Tommy",
                "Billy And Bob",
                2
            )
        )

        questionList.add(
            Question(
                15, "Black Panther is set in which fictional country?",
                R.drawable.black_panther,
                "Latveria",
                "Krakoa",
                "Wakanda",
                "Atlantis",
                3
            )
        )
        return questionList
    }

}