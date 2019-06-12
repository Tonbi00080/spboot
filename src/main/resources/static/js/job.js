// 初期表示
$(document).ready(function(){
	jobTypeInput = document.getElementById('jobTypeInput').value;
	if (jobTypeInput == '') {
		document.getElementById("jobType").selectedIndex = 1;
		var jobType = $('#jobTypePullDown option:selected').val();
		// jobの設定
		refreshJobs(jobType);
	} else {
		clearAll();
	}
});


function clearAll(){
	document.getElementById('name').value = '';
	document.getElementById('age').value = '';
	document.getElementById('jobInput').value = '';
	document.getElementById('jobTypeInput').value = '';
	document.getElementById('job').value = '';
	document.getElementById('jobType').value = '';
}

// JSONデータを国コードのプルダウンにセットする
function setPullDownJobs(data) {
	var obj = $.parseJSON(data);
	$('#jobPullDown').html('');
	for (var i = 0; i < obj.length; i++) {
		$('#jobPullDown').append(
				'<option value=' + obj[i].value + '>' + obj[i].label
						+ '</option>');
	}
}

function refreshJobs(jobType) {
	// ajax処理の通知
	var deferred = new $.Deferred();
	$.get('/sample5/jobType/' + jobType, function(data) {
		setPullDownJobs(data);
	}).always(function() {
		// ajax処理を終了
		deferred.resolve();
	});
	return deferred;
}

// 仕事選択
$('#jobPullDown').change(function() {
	var job = $('#jobPullDown option:selected').val();
	document.getElementById('jobInput').value = job;
});

// 職種選択時に仕事のプルダウンをリフレッシュする
$('#jobTypePullDown').change(function() {
	var jobType = $('#jobTypePullDown option:selected').val();
	document.getElementById('jobTypeInput').value = jobType;
	refreshJobs(jobType);
});

function submitPerson() {
	var jobType = document.getElementById('jobTypeInput').value;
	document.getElementById('jobType').value = jobType;
	var job = document.getElementById('jobInput').value;
	document.getElementById('job').value = job;
}