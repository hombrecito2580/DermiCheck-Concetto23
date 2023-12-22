package com.example.masterstack23.data

//import org.bson.codecs.pojo.annotations.BsonId
//import org.bson.types.ObjectId

data class BlogDataMongo(
//    @BsonId val id: ObjectId = ObjectId(),
    val title: String,
    val p1: String,
    val p2: String,
    val imageURL: String
)
