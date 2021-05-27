# ProductControllerApi

All URIs are relative to *https://localhost:8898*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteProductUsingDELETE**](ProductControllerApi.md#deleteProductUsingDELETE) | **DELETE** /product/{productId} | deleteProduct
[**getsingleProductUsingGET**](ProductControllerApi.md#getsingleProductUsingGET) | **GET** /product/{productId} | getsingleProduct


<a name="deleteProductUsingDELETE"></a>
# **deleteProductUsingDELETE**
> String deleteProductUsingDELETE(productId)

deleteProduct

### Example
```java
// Import classes:
//import com.swagger.client.codegen.rest.invoker.ApiException;
//import com.swagger.client.codegen.rest.api.ProductControllerApi;


ProductControllerApi apiInstance = new ProductControllerApi();
Integer productId = 56; // Integer | productId
try {
    String result = apiInstance.deleteProductUsingDELETE(productId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductControllerApi#deleteProductUsingDELETE");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productId** | **Integer**| productId |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getsingleProductUsingGET"></a>
# **getsingleProductUsingGET**
> Product getsingleProductUsingGET(productId)

getsingleProduct

### Example
```java
// Import classes:
//import com.swagger.client.codegen.rest.invoker.ApiException;
//import com.swagger.client.codegen.rest.api.ProductControllerApi;


ProductControllerApi apiInstance = new ProductControllerApi();
Integer productId = 56; // Integer | productId
try {
    Product result = apiInstance.getsingleProductUsingGET(productId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductControllerApi#getsingleProductUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productId** | **Integer**| productId |

### Return type

[**Product**](Product.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

