    function previewImage(targetObj, previewId) {

        var preview = document.getElementById(previewId); //div id   
        var ua = window.navigator.userAgent;

        if (ua.indexOf("MSIE") > -1) {//ie일때

            targetObj.select();

            try {
                var src = document.selection.createRange().text; // get file full path 
                var ie_preview_error = document
                        .getElementById("ie_preview_error_" + previewId);

                if (ie_preview_error) {
                    preview.removeChild(ie_preview_error); //error가 있으면 delete
                }

                var img = document.getElementById(previewId); //이미지가 뿌려질 곳 

                img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"
                        + src + "', sizingMethod='scale')"; //이미지 로딩, sizingMethod는 div에 맞춰서 사이즈를 자동조절 하는 역할
            } catch (e) {
                if (!document.getElementById("ie_preview_error_" + previewId)) {
                    var info = document.createElement("<p>");
                    info.id = "ie_preview_error_" + previewId;
                    info.innerHTML = "a";
                    preview.insertBefore(info, null);
                }
            }
        } else { //ie가 아닐때
            var files = targetObj.files;
            for ( var i = 0; i < files.length; i++) {

                var file = files[i];

                var imageType = /image.*/; //이미지 파일일경우만.. 뿌려준다.
                if (!file.type.match(imageType))
                    continue;

                var prevImg = document.getElementById("prev_" + previewId); //이전에 미리보기가 있다면 삭제
                if (prevImg) {
                    preview.removeChild(prevImg);
                }

                var img = document.createElement("img"); //크롬은 div에 이미지가 뿌려지지 않는다. 그래서 자식Element를 만든다.
                img.id = "prev_" + previewId;
                img.classList.add("obj");
                img.file = file;
                img.style.width = '100px'; //기본설정된 div의 안에 뿌려지는 효과를 주기 위해서 div크기와 같은 크기를 지정해준다.
                
                
                preview.appendChild(img);

                if (window.FileReader) { // FireFox, Chrome, Opera 확인.
                    var reader = new FileReader();
                    reader.onloadend = (function(aImg) {
                        return function(e) {
                            aImg.src = e.target.result;
                        };
                    })(img);
                    reader.readAsDataURL(file);
                } else { // safari is not supported FileReader
                    //alert('not supported FileReader');
                    if (!document.getElementById("sfr_preview_error_"
                            + previewId)) {
                        var info = document.createElement("p");
                        info.id = "sfr_preview_error_" + previewId;
                        info.innerHTML = "not supported FileReader";
                        preview.insertBefore(info, null);
                    }
                }
            }
        }
    }
    
    function isNumberKey(evt){
        var charCode = (evt.which) ? evt.which : event.keyCode
        if (charCode > 31 && (charCode < 48 || charCode > 57))
            return false;
        return true;
    }
    
    /**
     * 1. 함수명 	: numberOnly
     * 2. 리턴타입	: void
     * 3. 함수인자	: 
     * 4. 작성일	: 2013. 11. 10.오후 2:02:16
     * 5. 작성자	: 김덕원
     * 6. 설명		: 숫자만 입력 가능하게 하는 함수.
     */
    function numberOnly(txb) { //onKeyUp="numberOnly(this);"
    	  txb.value = txb.value.replace(/[^\0-9]/ig, "");
    }

    /**
     * 1. 함수명 	: checkNumber
     * 2. 리턴타입	: void
     * 3. 함수인자	: 
     * 4. 작성일	: 2013. 11. 10.오후 2:02:16
     * 5. 작성자	: 김덕원
     * 6. 설명		: 숫자만 입력 가능하게 하는 함수. onPropertyChange=checkNumber()
     */
    
    function checkNumber() {
        var objEv = event.srcElement;
        var numPattern = /([^0-9])/;
        var numPattern = objEv.value.match(numPattern);
        if (numPattern != null) {
             alert("숫자만 입력하세요");
             objEv.value =objEv.value .replace(/([^0-9])/, "");
             objEv.focus();
             return false;
        }
   }
    
    /**
     * 1. 함수명 	: trim
     * 2. 리턴타입	: void
     * 3. 함수인자	: String
     * 4. 작성일	: 2014. 08. 18.오후 2:02:16
     * 5. 작성자	: 김덕원
     * 6. 설명		: 숫자만 입력 가능하게 하는 함수. onPropertyChange=checkNumber()
     */
    function trim(x) {
        return x.replace(/^\s+|\s+$/gm,'');
    }
    	
	/**
	 * 1. 함수명 	: layer_open
	 * 2. 리턴타입	: void
	 * 3. 함수인자	: 
	 * 4. 작성일	: 2013. 11. 10.오후 12:48:10
	 * 5. 작성자	: 김덕원
	 * 6. 설명		: 레이어 팝업 - 사용법  <a class="btn-example" onclick="layer_open('layer2');return false;" href="#">예제-2 보기</a>
	 */

	function layer_open(el){

		var temp = $('#' + el);
		var bg = temp.prev().hasClass('bg');	//dimmed 레이어를 감지하기 위한 boolean 변수

		if(bg){
			$('.layer').fadeIn();	//'bg' 클래스가 존재하면 레이어가 나타나고 배경은 dimmed 된다. 
		}else{
			temp.fadeIn();
		}
		
		// 화면의 중앙에 레이어를 띄운다.
		if (temp.outerHeight() < $(document).height() ) temp.css('margin-top', '-'+temp.outerHeight()/2+'px');
		else temp.css('top', '0px');
		if (temp.outerWidth() < $(document).width() ) temp.css('margin-left', '-'+temp.outerWidth()/2+'px');
		else temp.css('left', '0px');

		temp.find('a.cbtn').click(function(e){
			if(bg){
				$('.layer').fadeOut(); //'bg' 클래스가 존재하면 레이어를 사라지게 한다. 
			}else{
				temp.fadeOut();
			}
			e.preventDefault();
		});

		$('.layer .bg').click(function(e){	//배경을 클릭하면 레이어를 사라지게 하는 이벤트 핸들러
			$('.layer').fadeOut();
			e.preventDefault();
		});
		
		$('#layerClose').click(function(){
			$('.layer').fadeOut();
		});
		
	}		
	
	function layer_open2(el){

		var temp = $('#' + el);
		
		var bg = temp.prev().hasClass('bg2');	//dimmed 레이어를 감지하기 위한 boolean 변수

		if(bg){
			$('.layer2').fadeIn();	//'bg' 클래스가 존재하면 레이어가 나타나고 배경은 dimmed 된다. 
		}else{
			temp.fadeIn();
		}		
		// 화면의 중앙에 레이어를 띄운다.
		if (temp.outerHeight() < $(document).height() ) temp.css('margin-top', '-'+temp.outerHeight()/2+'px');
		else temp.css('top', '0px');
		if (temp.outerWidth() < $(document).width() ) temp.css('margin-left', '-'+temp.outerWidth()/2+'px');
		else temp.css('left', '0px');
		
		temp.find('a.cbtn2').click(function(e){
			if(bg){
				$('.layer2').fadeOut(); //'bg' 클래스가 존재하면 레이어를 사라지게 한다. 
			}else{
				temp.fadeOut();
			}
			e.preventDefault();
		});
		
		$('.layer2 .bg2').click(function(e){	//배경을 클릭하면 레이어를 사라지게 하는 이벤트 핸들러
			$('.layer2').fadeOut();
			e.preventDefault();
		});
		
		$('#layerClose2').click(function(){
			$('.layer2').fadeOut();
		});
		
	}		
	
	
	
	
