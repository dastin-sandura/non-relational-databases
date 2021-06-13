printjson(
    db.people.find(
        {weight:
			{"$gte":"68","$lte":"71.49"}
		}
    )
    .toArray()
)