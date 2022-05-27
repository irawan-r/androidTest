package com.amora.testandroid.api

import com.amora.testandroid.model.AndroidResponse
import com.amora.testandroid.model.ResponseItem
import com.squareup.moshi.*
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.util.*


class SingleToArrayAdapter {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    private val listType = Types.newParameterizedType(List::class.java, AndroidResponse::class.java)
    private val adapter: JsonAdapter<List<ResponseItem>> = moshi.adapter(listType)
    val pushPortMessageList = adapter.fromJson(toString())
}

/*@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
@JsonQualifier
annotation class SingleToArray
class SingleToArrayAdapter(
    private val delegateAdapter: JsonAdapter<List<Any>>,
    private val elementAdapter: JsonAdapter<Any>,
) : JsonAdapter<Any>() {

    companion object {
        val INSTANCE = SingleToArrayAdapterFactory()
    }

    override fun fromJson(reader: JsonReader): Any? =
        if (reader.peek() != JsonReader.Token.BEGIN_ARRAY) {
            Collections.singletonList(elementAdapter.fromJson(reader))
        } else delegateAdapter.fromJson(reader)

    override fun toJson(writer: JsonWriter, value: Any?) =
        throw UnsupportedOperationException("SingleToArrayAdapter is only used to deserialize objects")

    class SingleToArrayAdapterFactory : Factory {
        override fun create(
            type: Type,
            annotations: Set<Annotation>,
            moshi: Moshi,
        ): JsonAdapter<Any>? {
            val delegateAnnotations = Types.nextAnnotations(annotations, SingleToArray::class.java)
                ?: return null
            if (Types.getRawType(type) != List::class.java) throw IllegalArgumentException("Only lists may be annotated with @SingleToArray. Found: $type")
            val elementType = Types.collectionElementType(type, List::class.java)
            val delegateAdapter: JsonAdapter<List<Any>> = moshi.adapter(type, delegateAnnotations)
            val elementAdapter: JsonAdapter<Any> = moshi.adapter(elementType)

            return SingleToArrayAdapter(delegateAdapter, elementAdapter)
        }
    }
}*/
/*class Converter: JsonAdapter<AndroidResponse>() {
    private val moshi = Moshi.Builder()
        .add(Converter())
        .build()
    *//*@FromJson
    fun fromJson(
        reader: JsonReader,
        jsonAdapter: JsonAdapter<AndroidResponse>,
    ): List<AndroidResponse> {
        val list = ArrayList<AndroidResponse>()
        if (reader.hasNext()) {
            val token = reader.peek()
            if (token == JsonReader.Token.BEGIN_ARRAY) {
                reader.beginArray()
                while (reader.hasNext()) {
                    val yourResponse = jsonAdapter.fromJsonValue(reader.readJsonValue())
                    yourResponse?.let {
                        list.add(yourResponse)
                    }
                }
                reader.endArray()
            }
        }
        return list.toList()
    }*//*

    private val options: JsonReader.Options = JsonReader.Options.of("AndroidResponse")

    private val nullableListOfNullableResponseItemAdapter: JsonAdapter<List<ResponseItem?>?> =
        moshi.adapter(Types.newParameterizedType(List::class.java, ResponseItem::class.java),
            emptySet(), "response")

    override fun toString(): String = buildString(37) {
        append("GeneratedJsonAdapter(").append("AndroidResponse").append(')') }

    override fun fromJson(reader: JsonReader): AndroidResponse {
        var response: List<ResponseItem?>? = null
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 -> response = nullableListOfNullableResponseItemAdapter.fromJson(reader)
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        return AndroidResponse(
            response = response
        )
    }

    override fun toJson(writer: JsonWriter, value_: AndroidResponse?) {
        if (value_ == null) {
            throw NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("AndroidResponse")
        nullableListOfNullableResponseItemAdapter.toJson(writer, value_.response)
        writer.endObject()
    }
}*/

/*
class Converter (
    moshi: Moshi
) : JsonAdapter<AndroidResponse>() {

    private val options: JsonReader.Options = JsonReader.Options.of("AndroidResponse")

    private val nullableListOfNullableResponseItemAdapter: JsonAdapter<List<ResponseItem?>?> =
        moshi.adapter(Types.newParameterizedType(List::class.java, ResponseItem::class.java),
            emptySet(), "response")

    override fun toString(): String = buildString(37) {
        append("GeneratedJsonAdapter(").append("AndroidResponse").append(')') }

    override fun fromJson(reader: JsonReader): AndroidResponse {
        var response: List<ResponseItem?>? = null
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 -> response = nullableListOfNullableResponseItemAdapter.fromJson(reader)
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        return AndroidResponse(
            response = response
        )
    }

    override fun toJson(writer: JsonWriter, value_: AndroidResponse?) {
        if (value_ == null) {
            throw NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.")
        }
//        writer.beginObject()
        writer.name("AndroidResponse")
        nullableListOfNullableResponseItemAdapter.toJson(writer, value_.response)
//        writer.endObject()
    }

    */
/*
    @FromJson
    fun fromJson(
        reader: JsonReader,
        jsonAdapter: JsonAdapter<AndroidResponse>,
    ): List<AndroidResponse> {
        val list = ArrayList<AndroidResponse>()
        if (reader.hasNext()) {
            val token = reader.peek()
            if (token == JsonReader.Token.BEGIN_ARRAY) {
                reader.beginArray()
                while (reader.hasNext()) {
                    val yourResponse = jsonAdapter.fromJsonValue(reader.readJsonValue())
                    yourResponse?.let {
                        list.add(yourResponse)
                    }
                }
                reader.endArray()
            }
        }
        return list.toList()
    }

    override fun fromJson(reader: JsonReader): AndroidResponse? {
        TODO("Not yet implemented")
    }

    override fun toJson(writer: JsonWriter, value: AndroidResponse?) {
        TODO("Not yet implemented")
    }*//*


    */


