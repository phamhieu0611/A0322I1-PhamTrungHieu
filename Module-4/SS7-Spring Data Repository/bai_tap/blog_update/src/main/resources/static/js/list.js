function getListBook() {
    var nameBook = $("#nameBook").val();
    $.ajax({
        url: "http://localhost:8080/api/book/searchNameBook",
        data: {
            nameBook: nameBook
        },
        type: 'get',
        dataType: 'json',
        success: function(response) {
            var result = '';
            for (let i = 0; i < response.length; i++) {
                result += `<tr>
                    <td>${response[i].blogId}</td>
                    <td>${response[i].blogName}</td>
                    <td>${response[i].author}</td>
                </tr>`;
            }
            $("#result").html(result);
        }
    });
}