let insert = db.people.insertOne({
    "sex" : "Male",
    "first_name" : "Dastin",
    "last_name" : "Sandura",
    "job" : "Boj",
    "email" : "liame@gmail.com",
    "location" : {
            "city" : "Warsaw",
            "address" : {
                    "streetname" : "De Gaulle",
                    "streetnumber" : "1"
            }
    },
    "description" : "noitpircsed",
    "height" : "201.68",
    "weight" : "89.5",
    "birth_date" : "2001-04-22T16:10:58Z",
    "nationality" : "Poland",
    "credit" : [
            {
                    "type" : "jcb",
                    "number" : "4017957170327",
                    "currency" : "EUR",
                    "balance" : "446312.86"
            }
    ]
})

printjsononeline(insert)